package com.bit.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.ChallengeDto;
import com.bit.fin.mapper.ChallengeMapper;

@Service
public class ChallengeService {

	@Autowired
	private ChallengeMapper challengeMapper;
	
	public void insertChallenge(ChallengeDto dto) 
	{
		challengeMapper.insertChallenge(dto);
	}
	
}
