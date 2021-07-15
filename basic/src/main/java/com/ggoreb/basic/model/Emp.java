package com.ggoreb.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long empno;
	String ename;
	String job;
	int deptno;
	
	@ManyToOne
	Dept dept;
}
