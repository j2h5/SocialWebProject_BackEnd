package com.bit.fin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.fin.dto.PayDto;
import com.bit.fin.mapper.PayMapper;

@Service
public class PayService implements PayServiceInter {

   @Autowired
      private PayMapper PayMapper;
   
   @Override
   public void insertPay(PayDto dto) {
      // TODO Auto-generated method stub
      PayMapper.insertPay(dto);
   }

   @Override
   public PayDto getData(int pay_num) {
      // TODO Auto-generated method stub
      return PayMapper.getData(pay_num);
   }

   @Override
   public List<PayDto> getAllDatas() {
      // TODO Auto-generated method stub
      return PayMapper.getAllDatas();
   }

}