package com.bit.fin.service;


import java.util.List;


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
    
//	   int result = ReviewMapper.insertReview(dto);
//	   setRating(dto.getClass_num());
//	   return result;
      ReviewMapper.insertReview(dto);
   }

   @Override
   public int deleteReview(ReviewDto dto) {
	   int result = ReviewMapper.deleteReview(dto.getClassreview_num());
	   
	   setRating(dto.getClass_num());
	   return result;
   }
   @Override
   public void setRating(int class_num) {
		Double ratingAvg = ReviewMapper.getRatingAverage(class_num);
		
		if(ratingAvg == null ) {
			ratingAvg = 0.0;
		}
		
		ReviewDto cys = new ReviewDto();
		cys.setClass_num(class_num);
		cys.setRatingAvg(ratingAvg);
		
		ReviewMapper.updateRating(cys);
	}





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


}