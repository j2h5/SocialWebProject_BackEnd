package com.bit.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.TutoraskDto;
import com.bit.fin.mapper.AuthMapper;

@Service
public class AuthService implements AuthServiceInter {

	@Autowired
	AuthMapper authmapper;
	
	@Override
	public void Authinsert(TutoraskDto dto) {
		// TODO Auto-generated method stub
		authmapper.Authinsert(dto);
	}

}
