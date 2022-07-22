package com.bit.fin.mapper;


	import java.util.List;
	import java.util.Map;

	import org.apache.ibatis.annotations.Mapper;
import com.bit.fin.dto.ReviewDto;

	@Mapper
	public interface ReviewMapper {
		public void insertReview(ReviewDto dto);
		public int getTotalCount();
		public List<ReviewDto> getAllDatas();

		
	}


