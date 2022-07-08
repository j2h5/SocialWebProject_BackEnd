package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.MoimDto;

@Mapper
public interface MoimMapper {
	public void insertmoim(MoimDto dto);
	public List<MoimDto> getmoimList(int num);
	
}
