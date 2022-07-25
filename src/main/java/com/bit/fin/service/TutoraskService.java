package com.bit.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.TutoraskDto;
import com.bit.fin.mapper.TutoraskMapper;

@Service
public class TutoraskService implements TutoraskServiceInter {

	@Autowired
	TutoraskMapper tutoraskMapper;
	
	@Override
	public void tutorAsk(TutoraskDto dto) {
		// TODO Auto-generated method stub
		tutoraskMapper.tutorAsk(dto);
	}
	
	@Override
	public List<TutoraskDto> getlist() {
		// TODO Auto-generated method stub
		return tutoraskMapper.getlist();
	}

	@Override
	public void update(TutoraskDto dto) {
		// TODO Auto-generated method stub
		tutoraskMapper.update(dto);
	}
}
