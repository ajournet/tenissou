package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Tournoi;

@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long>{

}
