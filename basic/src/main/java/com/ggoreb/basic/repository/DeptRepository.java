package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Dept;


@Repository
public interface DeptRepository extends JpaRepository<Dept, Long> {
	
}
