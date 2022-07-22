package com.bit.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bit.fin.dto.ChatMessageDto;
import com.bit.fin.dto.ChatMessageDto2;
import com.bit.fin.service.PublicChatService;

@CrossOrigin
@Controller
public class ChattingController {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	PublicChatService publicChatService;


	@MessageMapping("/message/{class_num}")	// /app/message
	@SendTo("/chatroom/public/{class_num}")
	private ChatMessageDto receivePublicMessage(@Payload ChatMessageDto chatMessageDto) {
		System.out.println("public:"+chatMessageDto);	
		
		if(chatMessageDto.getMessage()!=null) {
		publicChatService.insertMessage(chatMessageDto);
		}
		return chatMessageDto;
	}
	
	@MessageMapping("/private-message")
	public ChatMessageDto2 receivePrivateMessage(@Payload ChatMessageDto2 chatMessageDto2) {
		
		simpMessagingTemplate.convertAndSendToUser(chatMessageDto2.getReceiverName(), "/private", chatMessageDto2);
        System.out.println(chatMessageDto2);
		return chatMessageDto2;
	}
}
