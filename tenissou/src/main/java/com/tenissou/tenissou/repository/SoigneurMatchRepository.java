package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.SoigneurMatch;

@Repository
public interface SoigneurMatchRepository extends JpaRepository<SoigneurMatch, Long>{

}
