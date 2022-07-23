package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.ChatMessageDto;

@Mapper
public interface PublicChatMapper {
	public void insertMessage(ChatMessageDto dto);
	public List<ChatMessageDto> publicChatList(int class_num);
	
}
