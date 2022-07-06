package com.bit.fin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String u_id;
    private String u_password;
    private String u_nickname;
    private Set<AuthorityDto> authorityDtoSet;

}