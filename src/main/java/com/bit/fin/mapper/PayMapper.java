package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.PayDto;

@Mapper
public interface PayMapper {
   //+ - 수정
   public void insertPay(PayDto dto);
   public List<PayDto> getData(String pay_user_id);
   public List<PayDto> getAllDatas();
   public PayDto chk(PayDto dto);

}