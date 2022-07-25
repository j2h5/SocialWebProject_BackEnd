package com.bit.fin.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("tutorask")
@Data
public class TutoraskDto {
	private int ask_id;
	private int user_id;
	private String username;
	private String state;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/seoul")
	private Timestamp ask_date;	
	private String realname;
}
