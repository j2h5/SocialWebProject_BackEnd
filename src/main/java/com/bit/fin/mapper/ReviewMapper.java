package com.bit.fin.mapper;
	import java.util.List;
	import java.util.Map;
	import org.apache.ibatis.annotations.Mapper;
import com.bit.fin.dto.ReviewDto;
	@Mapper
	public interface ReviewMapper {
		public int insertReview(ReviewDto dto);
			
	
		public List<ReviewDto> getAllDatas(int class_num);
		//리뷰삭제하기
		public void deleteReview(int classreview_num);
		//평점 평균값 구하기
		public Double getRatingAverage(int class_num);
		
		//평점 평균 반영
		public int updateRating(ReviewDto dto);
		//총 리뷰 갯수 구하기
	}