package com.bit.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.LikeDto;
import com.bit.fin.mapper.LikeMapper;

@Service
public class LikeService implements LikeServiceInter {
	@Autowired
    private LikeMapper LikeMapper;
	@Override
	public int getTF(LikeDto dto) {
		// TODO Auto-generated method stub
		return LikeMapper.getTF(dto);
	}

	@Override
	public void pluslike(LikeDto dto) {
		// TODO Auto-generated method stub
		LikeMapper.pluslike(dto);
	}

	@Override
	public void minuslike(LikeDto dto) {
		// TODO Auto-generated method stub
		LikeMapper.minuslike(dto);
	}

}
