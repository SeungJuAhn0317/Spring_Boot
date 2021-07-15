package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
