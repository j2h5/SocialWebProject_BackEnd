package com.bit.fin.mapper;

import com.bit.fin.dto.UserDto;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Optional<UserDto> findOneWithAuthoritiesByUsername(String username);
    public UserDto getUser(String u_id);
    public void insertUser(UserDto dto);
    public int usernameCheck(String username); //해당 아이디 존재 유무 체크
    public int emailCheck(String email); //해당 이메일 존재 유무 체크
    public void insertProfile(UserDto dto);
}
