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

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.ClassoptionDto;
import com.bit.fin.mapper.ClassMapper;
import com.bit.fin.service.ClassService;
import com.bit.fin.util.FileUtil;



@RestController
@CrossOrigin
@RequestMapping("/class")
public class ClassController {
   @Autowired
   private ClassService classService;
//   @Autowired
//   private MemberService memberService; //이름얻기위함
   
   @Autowired
   private ClassMapper classMapper;
   
   String photoName; //리액트에서 업로드한 이미지명(변경된 이미지명일수도)

   //리액트에서 이미지 업로드시 save폴더에 저장 후 이미지명 변환
   @PostMapping("/upload")
   public String fileUpload(@RequestParam MultipartFile uploadFile,
         HttpServletRequest request) {
      //파일명
      String fileName=uploadFile.getOriginalFilename();

      //업로드할 폴더 위치구하기
      String path=request.getServletContext().getRealPath("/save");

      //직전 업로드한 이미지 존재할 경우 삭제
      File file = new File(path+"/"+photoName);
      if(file.exists()) {
         file.delete();
      }

      //파일명변경 by util.FileUtil
      FileUtil fileUtil=new FileUtil();
      photoName=fileUtil.changeFileName(fileName);
      System.out.println("fileName="+fileName+"=>"+photoName);

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
   public void insert(@RequestBody ClassDto dto,
         @RequestBody ClassoptionDto odto) {
      System.out.println(dto);
      System.out.println(odto);
      
      classService.insertClassOption(odto);
      classService.insertClass(dto);
      photoName=null; //이전 사진 삭제 안되게
   }
   
   @PostMapping("/insert2")
   public void insert2(@RequestBody List<ClassoptionDto> odto) {
	   
	   System.out.println(odto);
	   
	   classMapper.insertClassOption2(odto);
   }
   @PostMapping("/insert3")
   public void insert3(@RequestBody ClassoptionDto odto) {
	   
	   System.out.println(odto);
	   
	   classMapper.insertClassOption3(odto);
   }
   
//   @GetMapping("/detail")
//   public BoardDto detail(@RequestParam int num) {
//      //조회수 증가
//      boardService.updateReadCount(num);
//      //dto 반환
//      return boardService.getData(num);
//   }
//   
//   @GetMapping("/ulist")
//   public List<BoardDto> getAllList(){
//      return boardService.getAllDatas();
//   }
//   
   
   }