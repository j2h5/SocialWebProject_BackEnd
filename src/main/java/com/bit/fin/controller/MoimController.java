package com.bit.fin.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bit.fin.dto.MoimDto;
import com.bit.fin.mapper.MoimMapper;
import com.bit.fin.service.MoimService;
import com.bit.fin.util.FileUtil;

@RestController
@CrossOrigin
@RequestMapping("/moim")
public class MoimController {

	@Autowired
	private MoimService moimService;
	
	@Autowired
	MoimMapper moimmapper;

	String photoName; //리액트에서 업로드한 이미지명(변경)된 이미지명 일수도

	//리액트에서 이미지 업로드시 save폴더에 저장후 이미지명 반환
	@PostMapping("/upload")
	public String fileUpload(@RequestParam MultipartFile uploadFile,
			HttpServletRequest request)
	{
		//파일명
		String fileName=uploadFile.getOriginalFilename();
		System.out.println("fileName="+fileName);

		//업로드할 폴더 위치
		String path=request.getServletContext().getRealPath("/save");

		//직전에 업로드한 이미지 삭제하기
		File file=new File(path+"/"+photoName);

		// 만약 존재할 경우 삭제
		if(file.exists())
			file.delete();

		//파일명 변경
		FileUtil fileUtil=new FileUtil();
		photoName=fileUtil.changeFileName(fileName);



		//save폴더에 업로드
		try {
			uploadFile.transferTo(new File(path+"/"+photoName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoName;
	}

	@PostMapping("/insert")  
	public void insertShop(@RequestBody MoimDto dto)
	{
		
		System.out.println(dto);
		moimmapper.insertMoim(dto);
	}

	@GetMapping("/alllist")
	public List<MoimDto> getAllList()
	{
		return moimService.getAllDatas();
	}
	
	@GetMapping("/pagelist")
	public Map<String, Object> getPagingList(
			@RequestParam(defaultValue = "1") int currentPage
			)
	{
		System.out.println("currentPage="+currentPage);//페이징 처리
		int totalCount; //총 갯수
		int perPage=4; //한 페이지당 보여질 글의 갯수
		int perBlock=5; //한 블럭당 보여질 글의 갯수 (◀이전 1,2,3,4,5 다음▶)
		int totalPage; //총 페이지수
		int startNum; //한 페이지에서 보여질 시작 글번호
		int startPage; //한 블럭에서 보여질 시작 페이지 번호
		int endPage; //한 블럭에서 보여질 끝 페이지 번호
		int no; //각 페이지당 보여질 시작번호
		
		//총 글의 갯수를 구한다
		totalCount = moimService.getTotalCount();
		//총 페이지 수를 구한다
		totalPage = totalCount/perPage+(totalCount%perPage==0?0:1);
		//totalCount를 perPage로 나눈게 나머지 없으면 0이고 있으면 1 더하라.
		
//		방법2) totalPage = (int)Math.ceil((double)totalCount/perPage); //무조건 올림
		
		//각 블럭의 시작 페이지 (한 블럭당 5개씩 보여줌)
		//1,6,11 ... (currentPage 가 1~5 일때는 1, 6~10일때는 6)
		startPage = (currentPage-1)/perBlock*perBlock+1;
		// 0/0*0+1 -> 1 
		
		//5,10,15... (currentPage 가 1~5 일때는 1, 6~10일때는 10)
		endPage = startPage+perBlock-1;
		
		//문제점 (마지막 블럭은 총 페이지수까지만 나와야함) 
		//ex) 글이 12개밖에 없다면 11~15 페이지.. 블럭 12이까지만 나와야지!
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		//각 페이지에서 보여질 글의 시작번호 (mysql은 0부터)
		//ex) 한 페이지당 3개일 경우 1페이지 : 0, 2페이지: 3, 3페이지: 6
		startNum = (currentPage-1)*perPage;
		
		//각 페이지당 보여질 시작번호
		no = totalCount-(currentPage-1)*perPage;
		
		//데이터 가져오기
		List<MoimDto> list = moimService.getPagingList(startNum, perPage);
		
		//출력할 페이지 번호
		Vector<Integer> parr = new Vector<>();
		for(int pp = startPage; pp<=endPage; pp++) {
			parr.add(pp);
		}
		
		//리턴할 Map에 필요한 변수들 넣기
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("parr", parr);
		map.put("totalCount", totalCount);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("no", no);
		
		return map;
	}
	
}
