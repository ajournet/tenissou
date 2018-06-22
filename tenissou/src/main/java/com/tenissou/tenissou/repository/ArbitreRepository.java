package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Arbitre;
import com.tenissou.tenissou.model.Joueur;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long>{

}
