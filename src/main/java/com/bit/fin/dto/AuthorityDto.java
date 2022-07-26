package com.bit.fin.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("auth")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
//    private String authorityName;
    private String authority_name;
    private String user_id;
}