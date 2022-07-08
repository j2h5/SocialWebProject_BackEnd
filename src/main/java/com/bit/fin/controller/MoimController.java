package com.bit.fin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bit.fin.dto.MoimDto;
import com.bit.fin.service.MoimService;
import com.bit.fin.util.FileUtil;

@RestController
@CrossOrigin
@RequestMapping("/Moim")
public class MoimController {

	@Autowired
	private MoimService shopService;

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
		//업로드한 사진명
		dto.setMoim_photo(photoName);
		shopService.insertShop(dto);
		photoName=null;
	}

	
}
