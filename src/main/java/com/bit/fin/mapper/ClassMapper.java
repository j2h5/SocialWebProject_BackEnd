package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.ClassoptionDto;


@Mapper
public interface ClassMapper {
   //+ - 수정
   public void insertClass(ClassDto dto);
   public void insertClassOption(List<ClassoptionDto> odto);
   public int maxClassnum();
   public ClassDto getData(int class_num);
   public List<ClassoptionDto> getOptionsData(int class_num);
   public List<ClassDto> getAllDatas();

   
}