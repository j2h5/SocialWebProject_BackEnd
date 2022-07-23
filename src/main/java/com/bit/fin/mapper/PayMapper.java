package com.bit.fin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.fin.dto.PayDto;

@Mapper
public interface PayMapper {
   //+ - 수정
   public void insertPay(PayDto dto);
   public PayDto getData(int pay_num);
   public List<PayDto> getAllDatas();

}