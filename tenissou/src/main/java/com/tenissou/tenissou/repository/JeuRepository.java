package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.identity.JeuIdentity;
import com.tenissou.tenissou.model.Jeu;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, JeuIdentity>{
	

}
