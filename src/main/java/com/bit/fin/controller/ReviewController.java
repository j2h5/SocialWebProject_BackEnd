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
		   dto.setClassreview_photo(photoName);
	      ReviewService.insertReview(dto);
		   //id에 해당하는 이름 가져오기
//		   String name=UserService.getName(dto.getId());
//		   dto.setName(name);
		  
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
	   public List<ReviewDto> getAllList(@RequestParam int class_num)
	   {
		   System.out.println(1);
	      return ReviewService.getAllDatas(class_num);
	   }

	   @PostMapping("/delete")
	   public void DeleteReview(ReviewDto dto) {
		   ReviewService.deleteReview(dto);
	   }

	}


