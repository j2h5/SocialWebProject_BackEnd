package com.bit.fin.dto;


import org.apache.ibatis.type.Alias;


import lombok.Data;

@Alias("like")
@Data
public class LikeDto {
	private int like_num;
    private int like_class_num;
    private String like_user_name;
}
