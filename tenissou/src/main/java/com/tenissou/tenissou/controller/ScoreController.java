package com.tenissou.tenissou.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenissou.tenissou.exception.ResourceNotFoundException;
import com.tenissou.tenissou.identity.JeuIdentity;
import com.tenissou.tenissou.identity.SetIdentity;
import com.tenissou.tenissou.model.Jeu;
import com.tenissou.tenissou.model.Set;
import com.tenissou.tenissou.model.Tiebreak;
import com.tenissou.tenissou.repository.JeuRepository;
import com.tenissou.tenissou.repository.SetRepository;
import com.tenissou.tenissou.repository.TiebreakRepository;

@RestController
@RequestMapping("/api")
public class ScoreController {
	
	@Autowired
    JeuRepository jeuRepository;
	
	@Autowired
    SetRepository setRepository;
	
	@Autowired
    TiebreakRepository tiebreakRepository;
	
	//create a jeu
	@PostMapping("/match/{idSet}/{idJeu}/createJeu")
	public Jeu createJeu(@PathVariable(value = "idSet") Long idSet, 
			@PathVariable(value = "idJeu") Long idJeu) {
		
		JeuIdentity jeuIdentity = new JeuIdentity(idJeu, idSet);
		Jeu jeu = new Jeu(jeuIdentity, "0", "0");
		return jeuRepository.save(jeu);
	}
	
	//create a tiebreak
	@PostMapping("/match/{idSet}/createTiebreak")
	public Tiebreak createTiebreak(@PathVariable(value = "idSet") int idSet) {
		
		Tiebreak tiebreak = new Tiebreak(idSet, 0, 0);
		
		return tiebreakRepository.save(tiebreak);
	}
	
	// Update tiebreak J1
	@PutMapping("/match/{idTiebreak}/joueur1/{score}")
	public Tiebreak updateTiebreakJ1(@PathVariable(value = "idTiebreak") Long idTiebreak,
			@PathVariable(value = "score") long Score) {
		
		Tiebreak tiebreak = tiebreakRepository.findById(idTiebreak)
				.orElseThrow(() -> new ResourceNotFoundException("Tiebreak", "id", idTiebreak));
		
		tiebreak.setEquipe1Score(Score);
		tiebreak.setEquipe2Score(tiebreak.getEquipe2Score());
		
		Tiebreak updatedTiebreak = tiebreakRepository.save(tiebreak);
		
		return updatedTiebreak;
	}
	
	// Update tiebreak J2
	@PutMapping("/match/{idTiebreak}/joueur2/{score}")
	public Tiebreak updateTiebreakJ2(@PathVariable(value = "idTiebreak") Long idTiebreak,
			@PathVariable(value = "score") long Score) {
		
		Tiebreak tiebreak = tiebreakRepository.findById(idTiebreak)
				.orElseThrow(() -> new ResourceNotFoundException("Tiebreak", "id", idTiebreak));
		
		tiebreak.setEquipe1Score(tiebreak.getEquipe1Score());
		tiebreak.setEquipe2Score(Score);
		
		Tiebreak updatedTiebreak = tiebreakRepository.save(tiebreak);
		
		return updatedTiebreak;
	}
	
	// Update score J1 /15 || /30 ||/40 ||/40A
	@PutMapping("/match/{idSet}/{idJeu}/joueur1/{score}")
	public Jeu updateScoreJ1(@PathVariable(value = "idSet") Long idSet, 
			@PathVariable(value = "idJeu") Long idJeu, 
			@PathVariable(value = "score") String Score) {
		
		JeuIdentity jeuIdentity = new JeuIdentity();
		jeuIdentity.setIdJeu(idJeu);
		jeuIdentity.setIdSet(idSet);
		
		Jeu jeu = jeuRepository.findById(jeuIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Match", "id", idJeu));
		
		String score = Score;
		
		jeu.setEquipe1Point(score);
		jeu.setEquipe2Point(jeu.getEquipe2Point());
		
		Jeu updatedJeu= jeuRepository.save(jeu);
		
		return updatedJeu;
	}
	
	// Update score J2
	@PutMapping("/match/{idSet}/{idJeu}/joueur2/{score}")
	public Jeu updateScoreJ2(@PathVariable(value = "idSet") Long idSet, 
			@PathVariable(value = "idJeu") Long idJeu, 
			@PathVariable(value = "score") String Score) {
		
		JeuIdentity jeuIdentity = new JeuIdentity();
		jeuIdentity.setIdJeu(idJeu);
		jeuIdentity.setIdSet(idSet);
		
		Jeu jeu = jeuRepository.findById(jeuIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Match", "id", idJeu));
		
		String score = Score;
		
		jeu.setEquipe1Point(jeu.getEquipe1Point());
		jeu.setEquipe2Point(score);
		
		Jeu updatedJeu= jeuRepository.save(jeu);
		
		return updatedJeu;
	}
	
	// Update +1 jeu J1
	@PutMapping("/match/{idMatch}/{idSet}/joueur1")
	public Set updateJeuJ1(@PathVariable(value = "idSet") Long idSet, 
			@PathVariable(value = "idMatch") Long idMatch) {
		
		SetIdentity setIdentity = new SetIdentity();
		setIdentity.setIdMatch(idMatch);
		setIdentity.setIdSet(idSet);
		
		Set set = setRepository.findById(setIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Set", "id", idSet));
		
		set.setEquipe1Jeu(set.getEquipe1Jeu()+1);
		set.setEquipe2Jeu(set.getEquipe2Jeu());
		
		Set updatedSet= setRepository.save(set);
		
		return updatedSet;
	}
	
	// Update +1 jeu J2
	@PutMapping("/match/{idMatch}/{idSet}/joueur2")
	public Set updateJeuJ2(@PathVariable(value = "idSet") Long idSet, 
			@PathVariable(value = "idMatch") Long idMatch) {
		
		SetIdentity setIdentity = new SetIdentity();
		setIdentity.setIdMatch(idMatch);
		setIdentity.setIdSet(idSet);
		
		Set set = setRepository.findById(setIdentity)
				.orElseThrow(() -> new ResourceNotFoundException("Set", "id", idSet));
		
		set.setEquipe1Jeu(set.getEquipe1Jeu());
		set.setEquipe2Jeu(set.getEquipe2Jeu()+1);
		
		Set updatedSet= setRepository.save(set);
		
		return updatedSet;
	}
	
}
