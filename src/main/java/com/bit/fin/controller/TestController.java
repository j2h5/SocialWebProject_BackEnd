package com.bit.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.fin.dto.UserDto;
import com.bit.fin.mapper.UserMapper;

@RestController
public class TestController {
	
	@Autowired
	UserMapper userMapper;

    @RequestMapping(value="/")
    public String hello(){
        return "hello world!";
    }
    
    @GetMapping("/test")
    public UserDto test(String u_id) {

    	return userMapper.getUser(u_id);
    }


}
