package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.MoimDto;

public interface MoimServiceInter {

	public void insertMoim(MoimDto dto);	
	public int getTotalCount();
	public List<MoimDto> getPagingList(int start, int perpage);
	public List<MoimDto> getAllDatas();
	public MoimDto getData(int num);
}
