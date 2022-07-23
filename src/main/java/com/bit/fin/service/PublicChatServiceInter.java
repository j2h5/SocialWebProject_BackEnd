package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.ChatMessageDto;

public interface PublicChatServiceInter {
	public void insertMessage(ChatMessageDto dto);
	public List<ChatMessageDto> publicChatList(int class_num);

}
