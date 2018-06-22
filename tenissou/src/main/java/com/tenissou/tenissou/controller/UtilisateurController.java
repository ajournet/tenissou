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
import com.tenissou.tenissou.model.Utilisateur;
import com.tenissou.tenissou.repository.UtilisateurRepository;

@RestController
@RequestMapping("/api")
public class UtilisateurController {
	
	@Autowired
    UtilisateurRepository UtilisateurRepository;

	//Get all Players
	@GetMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
	    return UtilisateurRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createUtilisateur")
	public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
	    return UtilisateurRepository.save(utilisateur);
	}
	
	// Get a Single player
	@GetMapping("/utilisateurs/{id}")
	public Utilisateur getUtilisateurById(@PathVariable(value = "id") Long utilisateurId) {
	    return UtilisateurRepository.findById(utilisateurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));
	}
	
	// Update a player
	@PutMapping("/utilisateurs/{id}")
	public Utilisateur updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
	                                        @Valid @RequestBody Utilisateur UtilisateurDetails) {

		Utilisateur utilisateur = UtilisateurRepository.findById(utilisateurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

		utilisateur.setNom(UtilisateurDetails.getNom());
		utilisateur.setPrenom(UtilisateurDetails.getPrenom());
		utilisateur.setMail(UtilisateurDetails.getMail());

	    Utilisateur updatedUtilisateur = UtilisateurRepository.save(utilisateur);
	    return updatedUtilisateur;
	}
	
	// Delete a player
	@DeleteMapping("/utilisateurs/{id}")
	public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
		Utilisateur utilisateur = UtilisateurRepository.findById(utilisateurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateurId));

		UtilisateurRepository.delete(utilisateur);

	    return ResponseEntity.ok().build();
	}



}
