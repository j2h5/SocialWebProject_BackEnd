package com.bit.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.bit.fin.dto.ChatMessageDto;

@Controller
public class ChattingController {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;


	@MessageMapping("message")	// /app/message
	@SendTo("/chatroom/public")
	private ChatMessageDto receivePublicMessage(@Payload ChatMessageDto chatMessageDto) {
		System.out.println(chatMessageDto);
		return chatMessageDto;
	}
	
	@MessageMapping("/private-message")
	public ChatMessageDto receivePrivateMessage(@Payload ChatMessageDto chatMessageDto) {
		
		simpMessagingTemplate.convertAndSendToUser(chatMessageDto.getReceiverName(), "/private", chatMessageDto);
        System.out.println(chatMessageDto);
		return chatMessageDto;
	}
}
