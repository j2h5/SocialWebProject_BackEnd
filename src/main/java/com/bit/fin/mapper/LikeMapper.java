package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.LikeDto;

@Mapper
public interface LikeMapper {
	public int getTF(LikeDto dto);
	public void pluslike(LikeDto dto);
	public void minuslike(LikeDto dto);
	public List<LikeDto> likelist(String username);
}
