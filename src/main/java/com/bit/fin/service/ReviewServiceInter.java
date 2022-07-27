package com.bit.fin.service;


import java.util.List;


import com.bit.fin.dto.ReviewDto;




public interface ReviewServiceInter {
	public int insertReview(ReviewDto dto);
	
//	public int getReviewSum(int class_num);
	
	public void deleteReview(int classreview_num);
	
//	public void insertReview(ReviewDto dto);
	
	
	//	public List<ReviewDto> getPagingList(int start,int perpage);
	
	public List<ReviewDto> getAllDatas(int class_num);

	public void setRating(int class_num);

//	public void setReviewSum(int class_num);






	//	public ReviewDto getData(int num);

	//	public void updateReadCount(int num); //readcount 증가
	
}