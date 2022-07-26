package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.LikeDto;

public interface LikeServiceInter {
	public int getTF(LikeDto dto);
	public void pluslike(LikeDto dto);
	public void minuslike(LikeDto dto);
	public List<LikeDto> likelist(String username);
}
