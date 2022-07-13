package com.bit.fin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return challengeMapper.getTotalCount();
	}

	@Override
	public List<ChallengeDto> getPagingList(int start, int perpage) {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return challengeMapper.getPagingList(map);
	}

	@Override
	public List<ChallengeDto> getAllDatas() {
		return challengeMapper.getAllDatas();
	}

	@Override
	public ChallengeDto getData(int num) {
		return challengeMapper.getData(num);
	}

}
