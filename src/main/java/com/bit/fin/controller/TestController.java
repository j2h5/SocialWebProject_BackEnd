package com.bit.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.fin.mapper.UserMapper;


@RestController
public class TestController {
	
	@Autowired
	UserMapper userMapper;

    @RequestMapping(value="/")
    public String hello(String u_id){
    	
    	System.out.println(userMapper.getUser(u_id));

        return "hello world!";
    }

}
