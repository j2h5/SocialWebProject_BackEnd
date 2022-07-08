package com.bit.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.MoimDto;
import com.bit.fin.mapper.MoimMapper;

@Service
public class MoimService {
	
	@Autowired
	   private MoimMapper shopMapper;
	   
	   public void insertShop(MoimDto dto)
	   {
		   shopMapper.insertmoim(dto);
	   }
	   
//	   public List<MoimDto> getMoimDatas()
//	   {
//	      return shopMapper.getmoimList();
//	   
//	   }


}
