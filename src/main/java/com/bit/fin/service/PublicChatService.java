package com.bit.fin.service;

import java.util.List;

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
	
	@Override
	public List<ChatMessageDto> publicChatList(int class_num) {
		// TODO Auto-generated method stub
		return publicChatMapper.publicChatList(class_num);
	}

}
