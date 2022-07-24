package com.bit.fin.service;

import java.util.List;

import com.bit.fin.dto.PayDto;


public interface PayServiceInter {
   //+ - 수정
   public void insertPay(PayDto dto);
   public List<PayDto> getData(String pay_user_id);
   public List<PayDto> getAllDatas();
}