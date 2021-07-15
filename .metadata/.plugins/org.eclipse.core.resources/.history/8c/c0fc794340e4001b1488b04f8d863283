package com.ggoreb.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ggoreb.hospital.repository.HospitalRepository;

@Controller
public class HospitalController {
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping("/hospital")
	public String hospital(Model model) {
		model.addAttribute("list", hospitalRepository.findAll());
		return "hospital";
	}
}
