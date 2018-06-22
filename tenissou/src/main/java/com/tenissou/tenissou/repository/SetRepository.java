package com.tenissou.tenissou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenissou.tenissou.identity.SetIdentity;
import com.tenissou.tenissou.model.Set;

@Repository
public interface SetRepository extends JpaRepository<Set, SetIdentity>{
	

}
