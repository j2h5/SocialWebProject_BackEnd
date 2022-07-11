package com.bit.fin.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("classoption")
@Data
public class ClassoptionDto {
   private int classoption_num;
   private int class_num;
   private String classoption_day;
   private String classoption_starttime;
   private String classoption_endtime;
   private String classoption_totalperson;
   private String classoption_presentperson;
}