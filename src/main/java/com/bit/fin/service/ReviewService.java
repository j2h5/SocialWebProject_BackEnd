package com.bit.fin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.ReviewDto;
import com.bit.fin.mapper.ReviewMapper;

@Service
public class ReviewService implements ReviewServiceInter {

   @Autowired
   private ReviewMapper ReviewMapper;
   
   @Override
   public void insertReview(ReviewDto dto) {
      // TODO Auto-generated method stub
      ReviewMapper.insertReview(dto);
   }

   @Override
   public int getTotalCount() {
      // TODO Auto-generated method stub
      return ReviewMapper.getTotalCount();
   }

//   @Override
//   public List<ReviewDto> getPagingList(int start, int perpage) {
//      // TODO Auto-generated method stub
//      Map<String, Integer> map=new HashMap<>();
//      map.put("start", start);
//      map.put("perpage", perpage);
//         
//      return ReviewMapper.getPagingList(map);
//   }

   @Override
   public List<ReviewDto> getAllDatas(int class_num) {
      // TODO Auto-generated method stub
      return ReviewMapper.getAllDatas(class_num);
   }

//   @Override
//   public ReviewDto getData(int num) {
//      // TODO Auto-generated method stub
//      return ReviewMapper.getData(num);
//   }

//   @Override
//   public void updateReadCount(int num) {
//      // TODO Auto-generated method stub
//      ReviewMapper.updateReadCount(num);
//   }

}