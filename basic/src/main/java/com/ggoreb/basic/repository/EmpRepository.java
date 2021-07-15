package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Emp;


@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	
}
