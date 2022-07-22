package com.bit.fin.dto;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("review")
	@Data
	public class ReviewDto {

		private int classreview_num;
		private int class_num;
	
		private int classreview_rate;
		
		private String classreview_title;
		private String classreview_content;
		private String classreview_writer;
		private String classreview_photo;
		private Timestamp classreview_date;
	

	}

