package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
}
