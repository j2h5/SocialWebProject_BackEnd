package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.ClassoptionDto;


public interface ClassServiceInter {
   //+ - 수정
   public void insertClass(ClassDto dto);
   public void insertClassOption(List<ClassoptionDto> odto);
   public int maxClassnum();
   public ClassDto getData(int class_num);
   public List<ClassoptionDto> getOptionsData(int class_num);
   public List<ClassDto> getAllDatas();
   public void updateperson(int classoption_num,int pay_classoption_percnt);
}