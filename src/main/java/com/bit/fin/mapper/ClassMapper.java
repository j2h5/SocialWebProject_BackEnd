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
   public void insertClassOption3(ClassoptionDto odto);
   
   public void deleteClass(int classnum); 
    public void updateClass(ClassDto dto);
   //전체개수
   public int getTotalCount();
   //클래스 전체리스트
   public List<ClassDto> getAllDatas();
   //클래스 상세
   public ClassDto getData(int classnum);
   //클래스옵션List_이차원배열
   public List<ClassoptionDto> getClassoptionList(int classnum);
   
}