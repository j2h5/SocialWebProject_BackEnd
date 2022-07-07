package com.bit.fin.mapper;

import com.bit.fin.dto.UserDto;

import java.util.Optional;

public interface UserMapper {

    Optional<UserDto> findOneWithAuthoritiesByUsername(String username);
}
