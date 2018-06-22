package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.Membre;
import com.tenissou.tenissou.model.Organisation;
import com.tenissou.tenissou.model.Soigneur;

@Repository
public interface SoigneurRepository extends JpaRepository<Soigneur, Long>{

}
