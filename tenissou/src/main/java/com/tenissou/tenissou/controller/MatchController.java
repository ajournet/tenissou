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
import com.tenissou.tenissou.identity.EquipeMatchIdentity;
import com.tenissou.tenissou.model.Equipe;
import com.tenissou.tenissou.model.EquipeMatch;
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.Match;
import com.tenissou.tenissou.repository.EquipeMatchRepository;
import com.tenissou.tenissou.repository.EquipeRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.MatchRepository;

@RestController
@RequestMapping("/api")
public class MatchController {
	
	@Autowired
    MatchRepository matchRepository;
	
	@Autowired
	EquipeMatchRepository equipeMatchRepository;
	
	@Autowired
	EquipeRepository equipeRepository;
	
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
		
		List<EquipeMatch> listEquipeMatch = equipeMatchRepository.findByEquipeMatchIdentityIdMatch(matchId);
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		Joueur j;
		Equipe e;
		long idEquipe = 0;
		long idJoueur = 0;
		
		for(EquipeMatch equipeMatch : listEquipeMatch) {
			
			idEquipe = equipeMatch.getEquipeMatchIdentity().getIdEquipe();
			e = equipeRepository.findById(idEquipe)
					.orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeMatch.getEquipeMatchIdentity().getIdEquipe()));
			final long idJ1 = e.getIdJoueur1();
			j = joueurRepository.findById(e.getIdJoueur1())
		            .orElseThrow(() -> new ResourceNotFoundException("Joueur1", "id", idJ1));
			listJoueur.add(j);
			
			if(e.getIdJoueur2() != null || !"".equals(e.getIdJoueur2())) {
				final long idJ2 = e.getIdJoueur2();
				j = joueurRepository.findById(e.getIdJoueur2())
			            .orElseThrow(() -> new ResourceNotFoundException("Joueur2", "id", idJ2));
				listJoueur.add(j);
			}
		}
		
		return listJoueur;
			
	}
	
	// add a joueur match
	@PostMapping("/matchs/{id}/add/{idEquipe}")
	public EquipeMatch createEquipeMatch(@PathVariable(value = "id") Long matchId, @PathVariable(value = "idEquipe") Long equipeId) {
		
		EquipeMatch joueurMatch = new EquipeMatch();
		EquipeMatchIdentity joueurMatchIdentity = new EquipeMatchIdentity();
		
		joueurMatchIdentity.setIdEquipe(equipeId);
		joueurMatchIdentity.setIdMatch(matchId);
		
		joueurMatch.setEquipeMatchIdentity(joueurMatchIdentity);
		return equipeMatchRepository.save(joueurMatch);
		
	}

}
