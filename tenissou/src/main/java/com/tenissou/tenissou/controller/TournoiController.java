package com.tenissou.tenissou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenissou.tenissou.exception.ResourceNotFoundException;
import com.tenissou.tenissou.identity.JoueurMatchIdentity;
import com.tenissou.tenissou.identity.JoueurTournoiIdentity;
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.JoueurMatch;
import com.tenissou.tenissou.model.JoueurTournoi;
import com.tenissou.tenissou.model.Tournoi;
import com.tenissou.tenissou.repository.JoueurMatchRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.JoueurTournoiRepository;
import com.tenissou.tenissou.repository.TournoiRepository;

@RestController
@RequestMapping("/api")
public class TournoiController {
	
	@Autowired
    TournoiRepository tournoiRepository;
	
	@Autowired
	JoueurTournoiRepository joueurTournoiRepository;
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@GetMapping("/tournois")
	public List<Tournoi> getAllTournois() {
	    return tournoiRepository.findAll();
	}
	
	//create a tournoi
	@PostMapping("/createTournoi")
	public Tournoi createTournoi(@Valid @RequestBody Tournoi tournoi) {
		return tournoiRepository.save(tournoi);
	}
	
	// Get a Single tournoi
	@GetMapping("/tournois/{id}")
	public Tournoi getTournoiById(@PathVariable(value = "id") Long tournoiId) {
		return tournoiRepository.findById(tournoiId)
				.orElseThrow(() -> new ResourceNotFoundException("Tournoi", "id", tournoiId));
	}
	
	// Update a player
	@PutMapping("/tournois/{id}")
	public Tournoi updateTournoi(@PathVariable(value = "id") Long tournoiId,
			@Valid @RequestBody Tournoi TournoiDetails) {
		
		Tournoi tournoi = tournoiRepository.findById(tournoiId)
				.orElseThrow(() -> new ResourceNotFoundException("Tournoi", "id", tournoiId));
		
		tournoi.setLieuTournoi(TournoiDetails.getLieuTournoi());
		tournoi.setDateDebutTournoi(TournoiDetails.getDateDebutTournoi());
		tournoi.setDateFinTournoi(TournoiDetails.getDateFinTournoi());
		tournoi.setNomTournoi(TournoiDetails.getNomTournoi());
		tournoi.setTypeMatchTournoi(TournoiDetails.getTypeMatchTournoi());
		tournoi.setNbParticipant(TournoiDetails.getNbParticipant());
		tournoi.setCashprizeTournoi(TournoiDetails.getCashprizeTournoi());
		tournoi.setTypeTournoi(TournoiDetails.getTypeTournoi());
		tournoi.setGenreTournoi(TournoiDetails.getGenreTournoi());
		
		Tournoi updatedTournoi = tournoiRepository.save(tournoi);
		
		return updatedTournoi;
	}
	
	// Delete a player
	@DeleteMapping("/tournois/{id}")
	public ResponseEntity<?> deleteTournoi(@PathVariable(value = "id") Long tournoiId) {
		Tournoi tournoi = tournoiRepository.findById(tournoiId)
				.orElseThrow(() -> new ResourceNotFoundException("Tournoi", "id", tournoiId));
		
		tournoiRepository.delete(tournoi);
		
		return ResponseEntity.ok().build();
	}
	
	// Get a Joueur par match
	@GetMapping("/tournois/{id}/joueurs")
	public List<Joueur> getPlayersByMatchById(@PathVariable(value = "id") Long tournoiId) {
		
		List<JoueurTournoi> joueurTournoi = joueurTournoiRepository.findByJoueurTournoiIdentityIdTournoi(tournoiId);
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		Joueur j;
		long idJoueur = 0;
		
		for(JoueurTournoi joueur : joueurTournoi) {
			idJoueur = joueur.getJoueurTournoiIdentity().getIdJoueur();
			j = joueurRepository.findById(idJoueur)
					.orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", joueur.getJoueurTournoiIdentity().getIdJoueur()));
			listJoueur.add(j);
		}
		
		return listJoueur;
		
	}
	
	// add a joueur match
	@PostMapping("/tournois/{id}/add/{idJoueur}")
	public JoueurTournoi createJoueurMatch(@PathVariable(value = "id") Long tournoiId, @PathVariable(value = "idJoueur") Long joueurId) {
		
		JoueurTournoi joueurTournoi = new JoueurTournoi();
		JoueurTournoiIdentity joueurTournoiIdentity = new JoueurTournoiIdentity();
		
		joueurTournoiIdentity.setIdJoueur(joueurId);
		joueurTournoiIdentity.setIdTournoi(tournoiId);
		
		joueurTournoi.setJoueurTournoiIdentity(joueurTournoiIdentity);
		return joueurTournoiRepository.save(joueurTournoi);
	}
}
