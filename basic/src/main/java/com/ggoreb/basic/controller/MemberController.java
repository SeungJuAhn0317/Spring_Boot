package com.ggoreb.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggoreb.basic.model.Member;
import com.ggoreb.basic.repository.MemberRepository;

@Controller
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public String memberPost(@ModelAttribute Member member) {
		// 관련 데이터를 DB에 저장 또는 수정 또는 삭제
		memberRepository.save(member);
		return "redirect:/main";
	}
}
