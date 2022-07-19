package com.bit.fin.service;

import java.util.List;

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
   public void deleteClass(int classnum) {
      // TODO Auto-generated method stub
      classMapper.deleteClass(classnum);
   }

   @Override
   public void updateClass(ClassDto dto) {
      // TODO Auto-generated method stub
      classMapper.updateClass(dto);
   }

   @Override
   public int getTotalCount() {
      // TODO Auto-generated method stub
      return classMapper.getTotalCount();
   }

   @Override
   public List<ClassDto> getAllDatas() {
      // TODO Auto-generated method stub
      return classMapper.getAllDatas();
   }

   @Override
   public ClassDto getData(int classnum) {
      // TODO Auto-generated method stub
      return classMapper.getData(classnum);
   }

   @Override
   public List<ClassoptionDto> getClassoptionList(int classnum) {
      // TODO Auto-generated method stub
      return classMapper.getClassoptionList(classnum);
   }

}
