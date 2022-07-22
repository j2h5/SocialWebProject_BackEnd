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

	import com.bit.fin.dto.ReviewDto;
	import com.bit.fin.service.ReviewService;

//	import com.bit.fin.service.MemberService;
	import  com.bit.fin.util.FileUtil;

	@RestController
	@CrossOrigin
	@RequestMapping("/review")
	public class ReviewController {

	   @Autowired
	   private ReviewService ReviewService;
	   
//	   @Autowired
//	   private MemberService memberService;
   String photoName;//리액트에서 업로드한 이미지명


	   //리엑트에서 이미지 업로드시 save폴더에 저장후 이미지명 반환
	   @PostMapping("/upload")
	   public String fileUpload(@RequestParam MultipartFile uploadFile,
	         HttpServletRequest request)
	   {
	      //파일명
	      String fileName=uploadFile.getOriginalFilename();

	      //업로드할 폴더 위치
	      String path=request.getServletContext().getRealPath("/save");

	      //직전에 업로드한 이미지 삭제하기
	      File file=new File(path+"/"+photoName);
	      //만약 존재할경우 삭제
	      if(file.exists())
	         file.delete();

	      //파일명 변경
	      FileUtil fileUtil=new FileUtil();
	      photoName=fileUtil.changeFileName(fileName);
	      System.out.println("fileName="+fileName+"=>"+photoName);      
	      
	      //save 폴더에 업로드
	      try {
	         uploadFile.transferTo(new File(path+"/"+photoName));
	      } catch (IllegalStateException | IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return photoName;
	   }

	   @PostMapping("/insert")
	   public void insert(@RequestBody ReviewDto dto)
	   {
		   System.out.println(dto);
	      ReviewService.insertReview(dto);
		   //id에 해당하는 이름 가져오기
//		   String name=UserService.getName(dto.getId());
//		   dto.setName(name);
		   ReviewService.insertReview(dto);
		   photoName=null; //이전에 insert했던게 지워지기때문에 넣는당
	   }

//	   @GetMapping("/detail")
//	   public ReviewDto detail(@RequestParam int num)
//	   {
//	      //조회수 증가
//	      ReviewService.updateReadCount(num);
//	      //dto 반환
//	      return ReviewService.getData(num);
//	   }

	   @GetMapping("/alllist")
	   public List<ReviewDto> getAllList()
	   {
	      return ReviewService.getAllDatas();
	   }

//	   @GetMapping("/pagelist")
//	   public Map<String, Object> getPageList(
//	         @RequestParam(defaultValue = "1") int currentPage
//	         )
//	   {
//	      System.out.println("currentPage="+currentPage);
//	      //페이징 처리
//	      int totalCount;//총 갯수
//	      int perPage=2;//한페이지당 보여질 글의 갯수
//	      int perBlock=5;//한블럭당 보여질 페이지수
//	      int totalPage;//총 페이지수
//	      int startNum;//한페이지에서 보여질 시작 글번호
//	      int startPage;//한블럭에서 보여질 시작 페이지 번호
//	      int endPage;//한블럭에서 보여질 끝 페이지 번호
//	      int no;//각 페이지당 보여질 시작번호      
//
//	      //총 글의 갯수를 구한다
//	      totalCount=ReviewService.getTotalCount();
//	      //총 페이지수를 구한다
//	      totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
//	      //totalPage=(int)Math.ceil((double)totalCount/perPage);//무조건 올림
//	      //각 블럭의 시작페이지(한블럭당 5개일경우 예)
//	      //1,6,11...(currentPage 가 1~5 일때는 1, 6~10 일때는 6)
//	      startPage=(currentPage-1)/perBlock*perBlock+1;
//	      //5,10,15...(currentPage 가 1~5 일때는 5, 6~10 일때는 10)
//	      endPage=startPage+perBlock-1;
//	      //문제점(마지막 블럭은 총페이지수까지만 나와야한다)
//	      if(endPage>totalPage) {
//	         endPage=totalPage;
//	      }
//	      //각 페이지에서 보여질 글의 시작번호(mysql 은 0부터)
//	      //예)한페이지당 3개일경우 1페이지:0, 2페이지:3, 3페이지 :6....      
//	      startNum=(currentPage-1)*perPage;
//	      //각 페이지당 보여질 시작번호   
//	      no=totalCount-(currentPage-1)*perPage;
//	      //데이타 가져오기
//	      List<ReviewDto> list=ReviewService.getPagingList(startNum, perPage);
//	      
//	      //출력할 페이지 번호
//	      Vector<Integer> parr=new Vector<>();
//	      for(int pp=startPage;pp<=endPage;pp++) {
//	         parr.add(pp);
//	      }
//	      
//	      //리턴할 Map 에 필요한 변수들 넣기
//	      Map<String, Object> map=new HashMap<>();
//	      map.put("list", list);
//	      map.put("parr", parr);
//	      map.put("totalCount", totalCount);
//	      map.put("totalPage", totalPage);
//	      map.put("startPage", startPage);
//	      map.put("endPage", endPage);
//	      map.put("no",no);
//	      
//	      return map;
//	      
//	   }
	}


