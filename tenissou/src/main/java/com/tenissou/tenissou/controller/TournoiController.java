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
import com.tenissou.tenissou.identity.EquipeTournoiIdentity;
import com.tenissou.tenissou.model.Equipe;
import com.tenissou.tenissou.model.EquipeMatch;
import com.tenissou.tenissou.model.EquipeTournoi;
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.Tournoi;
import com.tenissou.tenissou.repository.EquipeRepository;
import com.tenissou.tenissou.repository.EquipeTournoiRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.TournoiRepository;

@RestController
@RequestMapping("/api")
public class TournoiController {
	
	@Autowired
    TournoiRepository tournoiRepository;
	
	@Autowired
	EquipeTournoiRepository equipeTournoiRepository;
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@Autowired
	EquipeRepository equipeRepository;
	
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
		
		List<EquipeTournoi> listEquipeTournoi = equipeTournoiRepository.findByEquipeTournoiIdentityIdTournoi(tournoiId);
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		Joueur j;
		Equipe e;
		long idEquipe = 0;
		long idJoueur = 0;
		
		for(EquipeTournoi equipeTournoi : listEquipeTournoi) {
			
			idEquipe = equipeTournoi.getEquipeTournoiIdentity().getIdEquipe();
			e = equipeRepository.findById(idEquipe)
					.orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeTournoi.getEquipeTournoiIdentity().getIdEquipe()));
			j = joueurRepository.findById(e.getIdJoueur1())
		            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", equipeTournoi.getEquipeTournoiIdentity().getIdEquipe()));
			listJoueur.add(j);
			
			if(e.getIdJoueur2() != null || !"".equals(e.getIdJoueur2())) {
				j = joueurRepository.findById(e.getIdJoueur2())
			            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", equipeTournoi.getEquipeTournoiIdentity().getIdEquipe()));
				listJoueur.add(j);
			}
		}
		
		return listJoueur;
		
	}
	
	// add a joueur match
	@PostMapping("/tournois/{id}/add/{idEquipe}")
	public EquipeTournoi createJoueurTournoi(@PathVariable(value = "id") Long tournoiId, @PathVariable(value = "idEquipe") Long equipeId) {
		
		EquipeTournoi joueurTournoi = new EquipeTournoi();
		EquipeTournoiIdentity joueurTournoiIdentity = new EquipeTournoiIdentity();
		
		joueurTournoiIdentity.setIdEquipe(equipeId);
		joueurTournoiIdentity.setIdTournoi(tournoiId);
		
		joueurTournoi.setEquipeTournoiIdentity(joueurTournoiIdentity);
		return equipeTournoiRepository.save(joueurTournoi);
	}
}
