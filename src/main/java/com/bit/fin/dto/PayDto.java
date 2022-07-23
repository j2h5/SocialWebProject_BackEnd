package com.bit.fin.dto;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("pay")
   @Data
   public class PayDto {

      private int pay_num;
      private String pay_order_num;
      private String pay_user_id;
      private String pay_user_name;
      private int pay_class_num;
      private String pay_class_name;
      private int pay_classoption_num;
      private String pay_classoption_day;
      private int pay_classoption_starttime;
      private int pay_classoption_endtime;
      private int pay_classoption_percnt;
      private int pay_price;
      private Timestamp pay_day;
   
   }
