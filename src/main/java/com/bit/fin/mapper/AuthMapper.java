package com.bit.fin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.TutoraskDto;

@Mapper
public interface AuthMapper {
	public void Authinsert(TutoraskDto dto);
}
