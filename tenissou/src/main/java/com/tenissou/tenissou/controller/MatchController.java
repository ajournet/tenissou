package com.tenissou.tenissou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.JoueurMatch;
import com.tenissou.tenissou.model.Match;
import com.tenissou.tenissou.repository.JoueurMatchRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.MatchRepository;

@RestController
@RequestMapping("/api")
public class MatchController {
	
	@Autowired
    MatchRepository matchRepository;
	
	@Autowired
	JoueurMatchRepository joueurMatchRepository;
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@GetMapping("/matchs")
	public List<Match> getAllMatchs() {
	    return matchRepository.findAll();
	}
	
	//create a match
	@PostMapping("/createMatch")
	public Match createMatch(@Valid @RequestBody Match match) {
		return matchRepository.save(match);
	}
	
	// Get a Single match
	@GetMapping("/matchs/{id}")
	public Match getMatchById(@PathVariable(value = "id") Long matchId) {
		return matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match", "id", matchId));
	}
	
	// Update a match
	@PutMapping("/matchs/{id}")
	public Match updateMatch(@PathVariable(value = "id") Long matchId,
			@Valid @RequestBody Match MatchDetails) {
		
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match", "id", matchId));
		
		match.setLieuMatch(MatchDetails.getLieuMatch());
		match.setIdTournoi(MatchDetails.getIdTournoi());
		match.setDateDebut(MatchDetails.getDateDebut());
		match.setEtatMatch(MatchDetails.getEtatMatch());
		match.setTerrainMatch(MatchDetails.getTerrainMatch());
		
		Match updatedMatch = matchRepository.save(match);
		
		return updatedMatch;
	}
	
	// Delete a player
	@DeleteMapping("/matchs/{id}")
	public ResponseEntity<?> deleteMatch(@PathVariable(value = "id") Long matchId) {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match", "id", matchId));
		
		matchRepository.delete(match);
		
		return ResponseEntity.ok().build();
	}
	
	// Get a Joueur par match
	@GetMapping("/matchs/{id}/joueurs")
	public List<Joueur> getPlayersByMatchById(@PathVariable(value = "id") Long matchId) {
		
		List<JoueurMatch> joueurMatch = joueurMatchRepository.findByJoueurMatchIdentityIdMatch(matchId);
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		Joueur j;
		long idJoueur = 0;
		
		for(JoueurMatch joueur : joueurMatch) {
			idJoueur = joueur.getJoueurMatchIdentity().getIdJoueur();
			j = joueurRepository.findById(idJoueur)
		            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", joueur.getJoueurMatchIdentity().getIdJoueur()));
			listJoueur.add(j);
		}
		
		return listJoueur;
			
	}
	
	// add a joueur match
	@PostMapping("/matchs/{id}/add/{idJoueur}")
	public JoueurMatch createJoueurMatch(@PathVariable(value = "id") Long matchId, @PathVariable(value = "idJoueur") Long joueurId) {
		
		JoueurMatch joueurMatch = new JoueurMatch();
		JoueurMatchIdentity joueurMatchIdentity = new JoueurMatchIdentity();
		
		joueurMatchIdentity.setIdJoueur(joueurId);
		joueurMatchIdentity.setIdMatch(matchId);
		
		joueurMatch.setJoueurMatchIdentity(joueurMatchIdentity);
		return joueurMatchRepository.save(joueurMatch);
		
	}

}
