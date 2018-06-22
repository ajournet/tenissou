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
import com.tenissou.tenissou.model.Membre;
import com.tenissou.tenissou.repository.MembreRepository;

@RestController
@RequestMapping("/api")
public class MembreController {
	
	@Autowired
    MembreRepository MembreRepository;

	//Get all Players
	@GetMapping("/membres")
	public List<Membre> getAllMembres() {
	    return MembreRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createMembre")
	public Membre createMembre(@Valid @RequestBody Membre membre) {
	    return MembreRepository.save(membre);
	}
	
	// Get a Single player
	@GetMapping("/membres/{id}")
	public Membre getMembreById(@PathVariable(value = "id") Long membreId) {
	    return MembreRepository.findById(membreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Membre", "id", membreId));
	}
	
	// Update a player
	@PutMapping("/membres/{id}")
	public Membre updateMembre(@PathVariable(value = "id") Long membreId,
	                                        @Valid @RequestBody Membre MembreDetails) {

		Membre membre = MembreRepository.findById(membreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Membre", "id", membreId));

		membre.setNom(MembreDetails.getNom());
		membre.setPrenom(MembreDetails.getPrenom());
		membre.setMail(MembreDetails.getMail());

	    Membre updatedMembre = MembreRepository.save(membre);
	    return updatedMembre;
	}
	
	// Delete a player
	@DeleteMapping("/membres/{id}")
	public ResponseEntity<?> deleteMembre(@PathVariable(value = "id") Long membreId) {
		Membre membre = MembreRepository.findById(membreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Membre", "id", membreId));

		MembreRepository.delete(membre);

	    return ResponseEntity.ok().build();
	}



}
