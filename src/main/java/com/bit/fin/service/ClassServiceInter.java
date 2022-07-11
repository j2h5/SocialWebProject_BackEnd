package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.ClassoptionDto;


public interface ClassServiceInter {
   //+ - 수정
   public void insertClass(ClassDto dto);
   public void insertClassOption(ClassoptionDto odto);
   
   public void deleteClass(int classnum); 
    public void updateClass(ClassDto dto);
   //전체개수
   public int getTotalCount();
   //클래스 전체리스트_일단
   public List<ClassDto> getAllDatas();
   //클래스 상세
   public ClassDto getData(int classnum);
   //클래스옵션List_이차원배열
   public List<ClassoptionDto> getClassoptionList(int classnum);
   
   //클래스리뷰List_이차원배열
   //public List<ClassreviewDto> getClassreivewList(int classnum);
   
   //public double getAvgRrate();
   //public List<ReviewDto> get3ReviewsList();
   
   //클래스 주문
   //public void insertClassoder(ClassDto dto);
    
   //이건 뭐지.. public int getOid(int pnum);
}