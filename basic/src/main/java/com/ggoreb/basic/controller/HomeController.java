package com.ggoreb.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		log.debug("Debug");
		log.error("error");
		System.out.println("sysout");
		return "home";
	}
}