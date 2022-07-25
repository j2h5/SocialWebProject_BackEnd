package com.bit.fin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.fin.dto.TutoraskDto;
import com.bit.fin.service.AuthService;
import com.bit.fin.service.TutoraskService;

@RestController
@CrossOrigin
@RequestMapping("/tutor")
public class TutoraskContorller {
	
	@Autowired
	TutoraskService tutoraskService;
	
	@Autowired
	AuthService authService;

	@PostMapping("/ask")
	public void ask(@RequestBody TutoraskDto dto) {
		System.out.println(dto);
		tutoraskService.tutorAsk(dto);
	}
	
	@PostMapping("/list")
	public List<TutoraskDto> list(){
		return tutoraskService.getlist();
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TutoraskDto dto){
		
		authService.Authinsert(dto);
		tutoraskService.update(dto);
	}
	@PostMapping("/update2")
	public void update2(@RequestBody TutoraskDto dto){
		tutoraskService.update(dto);
	}
}
