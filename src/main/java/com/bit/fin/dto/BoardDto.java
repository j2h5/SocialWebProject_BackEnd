package com.bit.fin.dto;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;


@Alias("board")
@Data
public class BoardDto {

		private int num;
		private int readcount;
		private String photo;
		private String id;
		private String name;
		private String subject;
		private String content;
		@JsonFormat(pattern ="yyyy-MM-dd HH:mm")
		private Timestamp writeday;
		private String day;
		
	}

