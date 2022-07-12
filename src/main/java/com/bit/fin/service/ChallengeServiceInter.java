package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.ChallengeDto;

public interface ChallengeServiceInter {

	public void insertChallenge(ChallengeDto dto);	
	public int getTotalCount();
	public List<ChallengeDto> getPagingList(int start, int perpage);
	public List<ChallengeDto> getAllDatas();
	public ChallengeDto getData(int num);
}
