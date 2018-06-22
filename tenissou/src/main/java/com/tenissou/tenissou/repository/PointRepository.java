package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Joueur;
import com.tenissou.tenissou.model.Points;

@Repository
public interface PointRepository extends JpaRepository<Points, Long>{

}
