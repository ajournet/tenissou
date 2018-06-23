package com.tenissou.tenissou.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	//create a set
	@PostMapping("/createSet")
	public Set createSet(@Valid @RequestBody Set set) {
		return setRepository.save(set);
	}
	
	//create a jeu
	@PostMapping("/createJeu")
	public Jeu createJeu(@Valid @RequestBody Jeu jeu) {
		return jeuRepository.save(jeu);
	}
	
	//create a tiebreak
	@PostMapping("/createTiebreak")
	public Tiebreak createTiebreak(@Valid @RequestBody Tiebreak tiebreak) {
		return tiebreakRepository.save(tiebreak);
	}
}
