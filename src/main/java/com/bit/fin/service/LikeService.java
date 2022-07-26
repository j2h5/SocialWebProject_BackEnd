package com.bit.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.LikeDto;
import com.bit.fin.mapper.LikeMapper;

@Service
public class LikeService implements LikeServiceInter {
	@Autowired
    private LikeMapper likeMapper;
	@Override
	public int getTF(LikeDto dto) {
		// TODO Auto-generated method stub
		return likeMapper.getTF(dto);
	}

	@Override
	public void pluslike(LikeDto dto) {
		// TODO Auto-generated method stub
		likeMapper.pluslike(dto);
	}

	@Override
	public void minuslike(LikeDto dto) {
		// TODO Auto-generated method stub
		likeMapper.minuslike(dto);
	}
	
	@Override
	public List<LikeDto> likelist(String username){
		// TODO Auto-generated method stub
		return likeMapper.likelist(username);
	}

}
