package com.bit.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.ChatMessageDto;
import com.bit.fin.mapper.PublicChatMapper;

@Service
public class PublicChatService implements PublicChatServiceInter {

	@Autowired
	PublicChatMapper publicChatMapper;
	
	@Override
	public void insertMessage(ChatMessageDto dto) {
		publicChatMapper.insertMessage(dto);

	}

}
