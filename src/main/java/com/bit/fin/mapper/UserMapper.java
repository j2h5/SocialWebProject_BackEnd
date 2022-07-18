package com.bit.fin.mapper;

import com.bit.fin.dto.UserDto;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Optional<UserDto> findOneWithAuthoritiesByUsername(String username);
    public UserDto getUser(String u_id);
    public void insertUser(UserDto dto);
}
