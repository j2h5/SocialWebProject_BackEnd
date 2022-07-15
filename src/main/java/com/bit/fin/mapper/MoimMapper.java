package com.bit.fin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.MoimDto;

@Mapper
public interface MoimMapper {
	public void insertMoim(MoimDto dto);
	public List<MoimDto> getPagingList(Map<String, Integer> map); //start, perpage
	public List<MoimDto> getAllDatas();
	public int getTotalCount();
	public MoimDto getData(int num);
}
