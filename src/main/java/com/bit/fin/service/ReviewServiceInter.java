package com.bit.fin.service;


import java.util.List;


import com.bit.fin.dto.ReviewDto;


public interface ReviewServiceInter {
	public void insertReview(ReviewDto dto);
	public int getTotalCount();
	public int deleteReview(ReviewDto dto);
	public void setRating(int class_num);
//	public List<ReviewDto> getPagingList(int start,int perpage);
	public List<ReviewDto> getAllDatas(int class_num);
//	public ReviewDto getData(int num);
//	public void updateReadCount(int num); //readcount 증가
	
}