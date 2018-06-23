package com.tenissou.tenissou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.identity.EquipeTournoiIdentity;
import com.tenissou.tenissou.model.EquipeTournoi;

@Repository
public interface EquipeTournoiRepository extends JpaRepository<EquipeTournoi, EquipeTournoiIdentity>{
	
	List<EquipeTournoi> findByEquipeTournoiIdentityIdTournoi(Long tournoiId);

}
