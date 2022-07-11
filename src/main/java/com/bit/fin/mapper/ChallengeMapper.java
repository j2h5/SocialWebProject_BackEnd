package com.bit.fin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.ChallengeDto;

@Mapper
public interface ChallengeMapper {
	public void insertChallenge(ChallengeDto dto);
	public List<ChallengeDto> getPagingList(Map<String, Integer> map); //start, perpage
	public List<ChallengeDto> getAllDatas();
	public int getTotalCount();
	public ChallengeDto getData(int num);
}
