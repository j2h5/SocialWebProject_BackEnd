package com.bit.fin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.fin.dto.ChatMessageDto;
import com.bit.fin.service.PublicChatService;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageContorller {
	
	@Autowired
	PublicChatService publicChatService;

	@GetMapping("/get")
	public List<ChatMessageDto> messagelist(@RequestParam int class_num){
		System.out.println(publicChatService.publicChatList(class_num));
		return publicChatService.publicChatList(class_num);
	}

}
