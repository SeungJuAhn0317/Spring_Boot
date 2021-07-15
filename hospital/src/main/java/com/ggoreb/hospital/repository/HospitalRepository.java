package com.ggoreb.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggoreb.hospital.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
