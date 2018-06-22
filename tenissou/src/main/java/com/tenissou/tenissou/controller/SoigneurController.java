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
import com.tenissou.tenissou.model.Soigneur;
import com.tenissou.tenissou.repository.SoigneurRepository;

@RestController
@RequestMapping("/api")
public class SoigneurController {
	
	@Autowired
    SoigneurRepository SoigneurRepository;

	//Get all Players
	@GetMapping("/soigneurs")
	public List<Soigneur> getAllSoigneurs() {
	    return SoigneurRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createSoigneur")
	public Soigneur createSoigneur(@Valid @RequestBody Soigneur soigneur) {
	    return SoigneurRepository.save(soigneur);
	}
	
	// Get a Single player
	@GetMapping("/soigneurs/{id}")
	public Soigneur getSoigneurById(@PathVariable(value = "id") Long soigneurId) {
	    return SoigneurRepository.findById(soigneurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Soigneur", "id", soigneurId));
	}
	
	// Update a player
	@PutMapping("/soigneurs/{id}")
	public Soigneur updateSoigneur(@PathVariable(value = "id") Long soigneurId,
	                                        @Valid @RequestBody Soigneur SoigneurDetails) {

		Soigneur soigneur = SoigneurRepository.findById(soigneurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Soigneur", "id", soigneurId));

		soigneur.setNom(SoigneurDetails.getNom());
		soigneur.setPrenom(SoigneurDetails.getPrenom());

	    Soigneur updatedSoigneur = SoigneurRepository.save(soigneur);
	    return updatedSoigneur;
	}
	
	// Delete a player
	@DeleteMapping("/soigneurs/{id}")
	public ResponseEntity<?> deleteSoigneur(@PathVariable(value = "id") Long soigneurId) {
		Soigneur soigneur = SoigneurRepository.findById(soigneurId)
	            .orElseThrow(() -> new ResourceNotFoundException("Soigneur", "id", soigneurId));

		SoigneurRepository.delete(soigneur);

	    return ResponseEntity.ok().build();
	}



}
