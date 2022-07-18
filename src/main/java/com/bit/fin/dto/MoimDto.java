package com.bit.fin.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Alias("moim")
@Data
public class MoimDto {
	private int moim_num;
	private String moim_name;
	private String moim_leader;
	private String moim_place;
	private String moim_category;
	private String moim_photo;
	private String moim_content;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Timestamp writeday;

}
