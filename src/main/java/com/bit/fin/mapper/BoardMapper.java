package com.bit.fin.mapper;


	import java.util.List;
	import java.util.Map;

	import org.apache.ibatis.annotations.Mapper;

	import com.bit.fin.dto.BoardDto;

	@Mapper
	public interface BoardMapper {
		public void insertBoard(BoardDto dto);
		public int getTotalCount();
		public List<BoardDto> getPagingList(Map<String, Integer> map);
		public List<BoardDto> getAllDatas();
		public BoardDto getData(int num);
		public void updateReadCount(int num); //readcount 증가
		
	}


