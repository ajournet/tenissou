package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Tiebreak;

@Repository
public interface TiebreakRepository extends JpaRepository<Tiebreak, Long>{

}
