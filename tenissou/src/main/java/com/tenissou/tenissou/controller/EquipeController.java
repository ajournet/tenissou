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
import com.tenissou.tenissou.model.Equipe;
import com.tenissou.tenissou.model.EquipeMatch;
import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.repository.EquipeRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.EquipeRepository;

@RestController
@RequestMapping("/api")
public class EquipeController {
	
	@Autowired
	EquipeRepository equipeRepository;

	@Autowired
	JoueurRepository joueurRepository;
	
	//Get all Equipes
	@GetMapping("/equipes")
	public List<Equipe> getAllEquipes() {
	    return equipeRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createEquipe")
	public Equipe createEquipe(@Valid @RequestBody Equipe equipe) {
	    return equipeRepository.save(equipe);
	}
	
	// Get a Single player
	@GetMapping("/equipes/{id}")
	public Equipe getEquipeById(@PathVariable(value = "id") Long equipeId) {
	    return equipeRepository.findById(equipeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeId));
	}
	
	// Get a JoueurEquipe
	@GetMapping("/equipes/{id}/joueurs")
	public List<Joueur> getJoueurEquipe(@PathVariable(value = "id") Long equipeId) {
		Equipe equipe = equipeRepository.findById(equipeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeId));
		
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		Joueur j1, j2;
		final long idJ1, idJ2;
		idJ1 = equipe.getIdJoueur1();
		j1 = joueurRepository.findById(equipe.getIdJoueur1())
				.orElseThrow(() -> new ResourceNotFoundException("Joueur1", "id", idJ1));

		listJoueur.add(j1);
		
		if(equipe.getIdJoueur2() != null || !"".equals(equipe.getIdJoueur2())) {
			idJ2 = equipe.getIdJoueur2();
			j2 = joueurRepository.findById(equipe.getIdJoueur2())
		            .orElseThrow(() -> new ResourceNotFoundException("Joueur", "id", idJ2));
			listJoueur.add(j2);
		}
		
		return listJoueur;
	}
	
	// Update a player
	@PutMapping("/equipes/{id}")
	public Equipe updateEquipe(@PathVariable(value = "id") Long equipeId,
	                                        @Valid @RequestBody Equipe EquipeDetails) {

		Equipe equipe = equipeRepository.findById(equipeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeId));

		equipe.setIdJoueur1(EquipeDetails.getIdJoueur1());
		equipe.setIdJoueur2(EquipeDetails.getIdJoueur2());
		
	    Equipe updatedEquipe = equipeRepository.save(equipe);
	    return updatedEquipe;
	}
	
	// Delete a player
	@DeleteMapping("/equipes/{id}")
	public ResponseEntity<?> deleteEquipe(@PathVariable(value = "id") Long equipeId) {
		Equipe equipe = equipeRepository.findById(equipeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", equipeId));

		equipeRepository.delete(equipe);

	    return ResponseEntity.ok().build();
	}



}
