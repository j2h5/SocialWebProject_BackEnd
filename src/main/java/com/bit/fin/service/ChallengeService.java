package com.bit.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.ChallengeDto;
import com.bit.fin.mapper.ChallengeMapper;

@Service
public class ChallengeService implements ChallengeServiceInter {

	@Autowired
	private ChallengeMapper challengeMapper;
	
	@Override
	public void insertChallenge(ChallengeDto dto) {
		challengeMapper.insertChallenge(dto);
	}

	@Override
	public int getTotalCount() {
		return 0;
	}

	@Override
	public List<ChallengeDto> getPagingList(int start, int perpage) {
		return null;
	}

	@Override
	public List<ChallengeDto> getAllDatas() {
		return null;
	}

	@Override
	public ChallengeDto getData(int num) {
		return null;
	}

}
