package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.TutoraskDto;

public interface TutoraskServiceInter {

	public void tutorAsk(TutoraskDto dto);
	public List<TutoraskDto> getlist();
	public void update(TutoraskDto dto);

}
