package com.tenissou.tenissou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.identity.EquipeMatchIdentity;
import com.tenissou.tenissou.model.EquipeMatch;

@Repository
public interface EquipeMatchRepository extends JpaRepository<EquipeMatch, EquipeMatchIdentity>{
	
	List<EquipeMatch> findByEquipeMatchIdentityIdMatch(Long matchId);

}
