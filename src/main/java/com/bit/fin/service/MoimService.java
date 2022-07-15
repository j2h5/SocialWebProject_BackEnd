
	package com.bit.fin.service;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.bit.fin.dto.MoimDto;
	import com.bit.fin.mapper.MoimMapper;

	@Service
	public class MoimService implements MoimServiceInter {

		@Autowired
		private MoimMapper moimMapper;
		
		@Override
		public void insertMoim(MoimDto dto) {
			moimMapper.insertMoim(dto);
		}

		@Override
		public int getTotalCount() {
			return moimMapper.getTotalCount();
		}

		@Override
		public List<MoimDto> getPagingList(int start, int perpage) {
			Map<String, Integer> map = new HashMap<>();
			map.put("start", start);
			map.put("perpage", perpage);
			
			return moimMapper.getPagingList(map);
		}

		@Override
		public List<MoimDto> getAllDatas() {
			return moimMapper.getAllDatas();
		}

		@Override
		public MoimDto getData(int num) {
			return moimMapper.getData(num);
		}

	

}
