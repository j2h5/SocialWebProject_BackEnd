package com.bit.fin.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("class")
@Data
public class ClassDto {
   private int class_num;
   private String  tutor_id;
   private String tutor_name;
   private String class_category;
   private String class_location;
   private String class_name;
   private String class_photo1;
   private String class_photo2;
   private String class_photo3;
   private String class_photo4;
   private String class_photo5;
   private String class_target;
   private int class_price;
   private int class_hour;
   private String classoption_num;
   private String class_intro;
   private String class_curri;
   private String class_anoun;
   private boolean class_anounok;   
   private String class_confirm;
   private String like_user_name;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/seoul")
   private Timestamp class_signday;
}