package com.ggoreb.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggoreb.hospital.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
//인터페이스는 추상메소드를 가진다. 메소드 몸통이 없다 
   List<Emp> findAllBySalGreaterThanEqual(int sal);
   List<Emp> findAllByDeptno(int deptno);
   List<Emp> findAllByEnameContainingOrderByEname(String ename);
}