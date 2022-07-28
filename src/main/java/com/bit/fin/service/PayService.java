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
   public List<PayDto> getData(String pay_user_id) {
      // TODO Auto-generated method stub
      return PayMapper.getData(pay_user_id);
   }

   @Override
   public List<PayDto> getAllDatas() {
      // TODO Auto-generated method stub
      return PayMapper.getAllDatas();
   }
   
   @Override
	public PayDto chk(PayDto dto) {
		// TODO Auto-generated method stub
		return PayMapper.chk(dto);
	}

}