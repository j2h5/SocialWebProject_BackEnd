package com.bit.fin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.ChatMessageDto;

@Mapper
public interface PublicChatMapper {
	public void insertMessage(ChatMessageDto dto);
	
}
