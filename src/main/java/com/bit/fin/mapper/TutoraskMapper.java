package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.TutoraskDto;

@Mapper
public interface TutoraskMapper {
	public void tutorAsk(TutoraskDto dto);
	public List<TutoraskDto> getlist();
	public void update(TutoraskDto dto);
}
