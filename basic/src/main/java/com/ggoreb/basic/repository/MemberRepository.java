package com.ggoreb.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggoreb.basic.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
}
