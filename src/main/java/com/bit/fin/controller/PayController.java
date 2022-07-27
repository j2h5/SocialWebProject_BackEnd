package com.bit.fin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bit.fin.dto.PayDto;
import com.bit.fin.service.ClassService;
import com.bit.fin.service.PayService;


@RestController
@CrossOrigin
@RequestMapping("/pay")
public class PayController {

   @Autowired
   private PayService PayService;
   @Autowired
   private ClassService classService;
   

   @PostMapping("/insert")
   public void insert(@RequestBody PayDto dto)
   {
      System.out.println(dto);
      PayService.insertPay(dto);
      classService.updateperson(dto);
      
       //해당하는 classnum맞춰서 classoption_pesentperson 증가
      //PayService.updateReadCount(num);~
   }

   @GetMapping	("/detail")
   public List<PayDto> detail(@RequestParam String pay_user_id)
   {
      //dto 반환
      return PayService.getData(pay_user_id);
   }

   @GetMapping("/list")
   public List<PayDto> getAllList()
   {
      return PayService.getAllDatas();
   }
   
   @GetMapping("/chk")
   public int chk(@RequestParam String pay_user_id) {
	   return PayService.chk(pay_user_id);
   }

}

