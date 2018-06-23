package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

}
