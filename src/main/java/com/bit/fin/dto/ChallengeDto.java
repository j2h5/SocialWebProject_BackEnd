package com.bit.fin.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("challenge")
@Data
public class ChallengeDto {
	private int challenge_id;
	private String challenge_title;
	private String challenge_title_photo;
	private String challenge_content;
	private String challenge_add_photos;
	
	private String challenge_certification_photos;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate challenge_startday;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate challenge_endday;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate challenge_countday;
	
	private int challenge_period;
	private String challenge_status;
	private int challenge_deposit;
	
}
