package com.bit.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.fin.dto.LikeDto;
import com.bit.fin.service.LikeService;

@RestController
@CrossOrigin
@RequestMapping("/like")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/check")
	public int insert(@RequestBody LikeDto dto) {
		System.out.println(dto);
		int count=likeService.getTF(dto);
		if(count==0) {
		likeService.pluslike(dto);
		System.out.println('+');
		return 1;
		}else {
		likeService.minuslike(dto);
		System.out.println('-');
		return 0;
		}
	}
	
	@PostMapping("/chk")
	public int chk(@RequestBody LikeDto dto) {

		return likeService.getTF(dto);
	}
}

