package com.tenissou.tenissou.controller;

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
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.repository.JoueurRepository;

@RestController
@RequestMapping("/api")
public class JoueurController {
	
	@Autowired
    JoueurRepository JoueurRepository;

	//Get all Players
	@GetMapping("/players")
	public List<Joueur> getAllPlayers() {
	    return JoueurRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createPlayer")
	public Joueur createPlayer(@Valid @RequestBody Joueur joueur) {
	    return JoueurRepository.save(joueur);
	}
	
	// Get a Single player
	@GetMapping("/players/{id}")
	public Joueur getPlayerById(@PathVariable(value = "id") Long joueurId) {
	    return JoueurRepository.findById(joueurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", joueurId));
	}
	
	// Update a player
	@PutMapping("/players/{id}")
	public Joueur updatePlayer(@PathVariable(value = "id") Long joueurId,
	                                        @Valid @RequestBody Joueur JoueurDetails) {

		Joueur joueur = JoueurRepository.findById(joueurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", joueurId));

		joueur.setNom(JoueurDetails.getNom());
		joueur.setPrenom(JoueurDetails.getPrenom());
		joueur.setPays(JoueurDetails.getPays());
		joueur.setAge(JoueurDetails.getAge());
		joueur.setClassement(JoueurDetails.getClassement());

	    Joueur updatedJoueur = JoueurRepository.save(joueur);
	    return updatedJoueur;
	}
	
	// Delete a player
	@DeleteMapping("/players/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") Long joueurId) {
		Joueur joueur = JoueurRepository.findById(joueurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", joueurId));

		JoueurRepository.delete(joueur);

	    return ResponseEntity.ok().build();
	}



}
