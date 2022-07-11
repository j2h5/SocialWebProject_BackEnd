package com.bit.fin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.ChallengeDto;

@Mapper
public interface ChallengeMapper {
	public void insertChallenge(ChallengeDto dto);
}
