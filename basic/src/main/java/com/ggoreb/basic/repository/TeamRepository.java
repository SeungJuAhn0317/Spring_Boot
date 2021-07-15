package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
