package com.bit.fin.dto;



import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("review")
	@Data
	public class ReviewDto {

		public int classreview_num;
		
		public int class_num;
	
		private int classreview_rate;
		
		private double ratingAvg;
		
		private int reviewSum;
		
//		public int getClass_num() {
//			return class_num;
//		}
		public void getClass_num(int class_num) {
			this.class_num = class_num;
		}
		public void setClass_num(int class_num) {
			this.class_num = class_num;
		}
		public double getRatingAvg() {
			return ratingAvg;
		}
	
		public void setRatingAvg(double ratingAvg) {
			this.ratingAvg =ratingAvg;
		}
		//sum
		public int getReviewSum() {
			return reviewSum;
		}
		
		public void setReviewSum(int reviewSum) {
			this.reviewSum = reviewSum;
		}
		@Override
		public String toString() {
//			return "ReviewDto [class_num=" + class_num + ", ratingAvg=" + ratingAvg + "]";
			return "ReviewDto [class_num=" + class_num + ", ratingAvg=" + ratingAvg + ", reviewSm=" + reviewSum + "]";
		}
		
		private String classreview_title;
	
		private String classreview_content;
		
		private String classreview_writer;
		
		private String classreview_photo;
		
		@JsonFormat(pattern="yyyy-MM-dd")
		
		private Timestamp classreview_date;

		

		

		
	

	}

