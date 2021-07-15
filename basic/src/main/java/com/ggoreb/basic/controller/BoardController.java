package com.ggoreb.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ggoreb.basic.model.Board;
import com.ggoreb.basic.model.FileAtch;
import com.ggoreb.basic.repository.BoardRepository;
import com.ggoreb.basic.repository.FileAtchRepository;

@Controller
public class BoardController {
	@Autowired BoardRepository boardRepository;
	@Autowired FileAtchRepository fileAtchRepository;
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public FileAtch writePost(@ModelAttribute Board board, MultipartFile abcd) {
		Board dbBoard = boardRepository.save(board);
		FileAtch fileAtch = new FileAtch();
		fileAtch.setBoard(dbBoard);
		fileAtch.setOriginName(abcd.getOriginalFilename());
		fileAtch.setSaveName(abcd.getOriginalFilename());
//		fileAtchRepository.save(fileAtch);
//		System.out.println(board);
//		System.out.println(abcd.getOriginalFilename());
		FileAtch result = fileAtchRepository.save( fileAtch );
		
		return result;
	}
}
