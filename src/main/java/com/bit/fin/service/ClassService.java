package com.bit.fin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.ClassoptionDto;
import com.bit.fin.mapper.ClassMapper;


@Service
public class ClassService implements ClassServiceInter {

   @Autowired
   private ClassMapper classMapper;
   
   @Override
   public void insertClass(ClassDto dto) {
      // TODO Auto-generated method stub
      classMapper.insertClass(dto);
   }
   
   @Override
   public void insertClassOption(List<ClassoptionDto> odto) {
      // TODO Auto-generated method stub
      classMapper.insertClassOption(odto);
   }
   
   @Override
	public int maxClassnum() {
		// TODO Auto-generated method stub
		return classMapper.maxClassnum();
	}

   @Override
   public ClassDto getData(int class_num) {
      // TODO Auto-generated method stub
      return classMapper.getData(class_num);
   }
   
   @Override
	public List<ClassoptionDto> getOptionsData(int class_num) {
		// TODO Auto-generated method stub
		return classMapper.getOptionsData(class_num);
	}
   
   @Override
   	public List<ClassDto> getAllDatas(){
	   return classMapper.getAllDatas();
   }
   
   @Override
	public void updateperson(int classoption_num, int pay_classoption_percnt) {
		// TODO Auto-generated method stub
	   
		Map<String, Integer> map=new HashMap<>();
		map.put("classoption_num", classoption_num);
		map.put("pay_classoption_percnt", pay_classoption_percnt);
		
		classMapper.updateperson(map);
		
	}

}
