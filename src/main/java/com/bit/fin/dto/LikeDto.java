package com.bit.fin.dto;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Alias("like")
@Data
public class LikeDto {
	private int like_num;
    private int like_class_num;
    private String like_user_name;
    //select 
    private int class_num;
    private String tutor_id;
    private String tutor_name;
    private String class_location;
    private String class_name;
    private String class_photo1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/seoul")
    private Timestamp class_signday;
}
