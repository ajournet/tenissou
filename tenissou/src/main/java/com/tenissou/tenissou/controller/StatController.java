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
import com.tenissou.tenissou.model.Stat;
import com.tenissou.tenissou.repository.StatRepository;

@RestController
@RequestMapping("/api")
public class StatController {
	
	@Autowired
    StatRepository StatRepository;

	//Get all Stats
	@GetMapping("/stats")
	public List<Stat> getAllStats() {
	    return StatRepository.findAll();
	}
	
	//create a player
	@PostMapping("/createStat")
	public Stat createStat(@Valid @RequestBody Stat stat) {
	    return StatRepository.save(stat);
	}
	
	// Get a Single player
	@GetMapping("/stats/{id}")
	public Stat getStatById(@PathVariable(value = "id") Long statId) {
	    return StatRepository.findById(statId)
	            .orElseThrow(() -> new ResourceNotFoundException("Stat", "id", statId));
	}
	
	// Update a player
	@PutMapping("/stats/{id}")
	public Stat updateStat(@PathVariable(value = "id") Long statId,
	                                        @Valid @RequestBody Stat StatDetails) {

		Stat stat = StatRepository.findById(statId)
	            .orElseThrow(() -> new ResourceNotFoundException("Stat", "id", statId));

		stat.setStatService(StatDetails.getStatService());
		stat.setWinrate(StatDetails.getWinrate());
		stat.setFauteDirecte(StatDetails.getFauteDirecte());
		stat.setStatSetGagne(StatDetails.getStatSetGagne());
		stat.setStatMatchGagne(StatDetails.getStatMatchGagne());

	    Stat updatedStat = StatRepository.save(stat);
	    return updatedStat;
	}
	
	// Delete a player
	@DeleteMapping("/stats/{id}")
	public ResponseEntity<?> deleteStat(@PathVariable(value = "id") Long statId) {
		Stat stat = StatRepository.findById(statId)
	            .orElseThrow(() -> new ResourceNotFoundException("Stat", "id", statId));

		StatRepository.delete(stat);

	    return ResponseEntity.ok().build();
	}



}
