package com.bit.fin.dto;



import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

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
		@JsonFormat(pattern="yyyy-MM-dd")
		private Timestamp classreview_date;
	

	}

