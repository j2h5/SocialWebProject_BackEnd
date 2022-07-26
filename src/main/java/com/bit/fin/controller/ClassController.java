package com.bit.fin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
   
   @Autowired
   private ClassMapper classMapper;
   
   
   //리액트에서 이미지 업로드시 save폴더에 저장 후 이미지명 변환
   @PostMapping("/upload")
   public String fileUpload(@RequestBody ArrayList<MultipartFile> uploadFiles,
         HttpServletRequest request) {
	   String fileName="";
	   String photoName="";
	   
	   
	   for(MultipartFile f:uploadFiles) {
      //파일명
      fileName=f.getOriginalFilename();
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
      //System.out.println("fileName="+fileName+"=>"+photoName);

      //save폴더에 업로드
      try {
         f.transferTo(new File(path+"/"+photoName));
      } catch (IllegalStateException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
	   }
      return photoName;
   }

   @PostMapping("/insert")
   public void insert(@RequestBody ClassDto dto) {
	   System.out.println(dto);
	   classService.insertClass(dto);
   }
   
   @PostMapping("/insert2")
   public void insert2(@RequestBody List<ClassoptionDto> odto) {
	   System.out.println(odto);
	   classMapper.insertClassOption(odto);
   }
   
   @PostMapping("/maxnum")
   public int getMaxNum() {
	   return classService.maxClassnum();
   }
   
   @GetMapping("/detail")
   public ClassDto getData(@RequestParam int class_num) {
	   return classService.getData(class_num);
   }
   
   @GetMapping("/detailoption")
   public List<ClassoptionDto> getOptionsData(@RequestParam int class_num) {
	   return classService.getOptionsData(class_num);
   }
   
   @GetMapping("/list")
   public List<ClassDto> getAllList(){
	   return classService.getAllDatas();
   }
   @GetMapping("/list2")
   public List<ClassDto> getAllList2(@RequestParam String username){
	   return classService.getAllDatas2(username);
   }
   
   @GetMapping("/mylist")
   public List<ClassDto> myclasslist(@RequestParam String username){
	   return classService.myclasslist(username);
   }
   
   @GetMapping("/mytuty")
   public List<ClassDto> myclasstuty(@RequestParam String username){
	   return classService.myclasstuty(username);
   }
   
   @GetMapping("/search")
   public List<ClassDto> search(@RequestParam String message){
      System.out.println(message);
      return classService.getSearch(message);
   }

   
   
      
}