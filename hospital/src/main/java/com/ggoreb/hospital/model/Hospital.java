package com.ggoreb.hospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	int id;
	String sido;
	String name;
	
}
