package com.bit.fin.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("challenge")
@Data
public class ChallengeDto {
	private int ch_id;
	private String ch_category;
	private String ch_title;
	private String ch_title_photo;
	private String ch_content;
	private String ch_add_photos;
	
	private String ch_certifi_exphoto;
	private String ch_certifi_exphoto2;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate ch_startday;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate ch_endday;
	
	private int ch_period;
	private String ch_status;
	private int ch_deposit;
	
}
