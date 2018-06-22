package com.tenissou.tenissou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.identity.JoueurTournoiIdentity;
import com.tenissou.tenissou.model.JoueurTournoi;

@Repository
public interface JoueurTournoiRepository extends JpaRepository<JoueurTournoi, JoueurTournoiIdentity>{
	
	List<JoueurTournoi> findByJoueurTournoiIdentityIdTournoi(Long tournoiId);

}
