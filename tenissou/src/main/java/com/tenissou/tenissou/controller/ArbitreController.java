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
import com.tenissou.tenissou.model.Arbitre;
import com.tenissou.tenissou.repository.ArbitreRepository;

@RestController
@RequestMapping("/api")
public class ArbitreController {
	
	@Autowired
    ArbitreRepository arbitreRepository;

	//Get all Players
	@GetMapping("/arbitres")
	public List<Arbitre> getAllArbitres() {
	    return arbitreRepository.findAll();
	}
	
	//Get all Players
	@GetMapping("/arbitre/{mail}/{password}")
	public Boolean isArbitre(@PathVariable(value = "mail") String mail, @PathVariable(value = "password") String password) {
		boolean login = false;
		
		List<Arbitre> listArbitre = arbitreRepository.findAll();
		
		for(Arbitre a : listArbitre) {
			if(a.getMailArbitre().equals(mail) && a.getPasswordArbitre().equals(password)) {
				login = true;
			}
		}
		
		return login;
	}
	
	//create a player
	@PostMapping("/createArbitre")
	public Arbitre createArbitre(@Valid @RequestBody Arbitre arbitre) {
	    return arbitreRepository.save(arbitre);
	}
	
	// Get a Single player
	@GetMapping("/arbitres/{id}")
	public Arbitre getArbitreById(@PathVariable(value = "id") Long arbitreId) {
	    return arbitreRepository.findById(arbitreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Arbitre", "id", arbitreId));
	}
	
	// Update a player
	@PutMapping("/arbitres/{id}")
	public Arbitre updateArbitre(@PathVariable(value = "id") Long arbitreId,
	                                        @Valid @RequestBody Arbitre ArbitreDetails) {

		Arbitre arbitre = arbitreRepository.findById(arbitreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Arbitre", "id", arbitreId));

		arbitre.setNom(ArbitreDetails.getNom());
		arbitre.setPrenom(ArbitreDetails.getPrenom());
		arbitre.setPays(ArbitreDetails.getPays());
		arbitre.setAge(ArbitreDetails.getAge());

	    Arbitre updatedArbitre = arbitreRepository.save(arbitre);
	    return updatedArbitre;
	}
	
	// Delete a player
	@DeleteMapping("/arbitres/{id}")
	public ResponseEntity<?> deleteArbitre(@PathVariable(value = "id") Long arbitreId) {
		Arbitre arbitre = arbitreRepository.findById(arbitreId)
	            .orElseThrow(() -> new ResourceNotFoundException("Arbitre", "id", arbitreId));

		arbitreRepository.delete(arbitre);

	    return ResponseEntity.ok().build();
	}



}
