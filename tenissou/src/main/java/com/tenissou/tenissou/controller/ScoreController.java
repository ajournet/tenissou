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
import com.tenissou.tenissou.repository.JeuRepository;
import com.tenissou.tenissou.repository.JoueurRepository;
import com.tenissou.tenissou.repository.PointRepository;
import com.tenissou.tenissou.repository.SetRepository;
import com.tenissou.tenissou.repository.TiebreakRepository;

@RestController
@RequestMapping("/api")
public class ScoreController {
	
	@Autowired
    PointRepository pointRepository;
	
	@Autowired
    JeuRepository jeuRepository;
	
	@Autowired
    SetRepository setRepository;
	
	@Autowired
    TiebreakRepository tiebreakRepository;

	



}
