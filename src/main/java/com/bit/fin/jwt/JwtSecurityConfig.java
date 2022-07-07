package com.bit.fin.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//TokenProvider과 JwtFilter를 SecurityConfig에 적용할 때 사용할 JwtSecurityConfig 클래스 추가
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private TokenProvider tokenProvider;

    //TokenProvider 주입받기
    public JwtSecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) {

        JwtFilter customFilter = new JwtFilter(tokenProvider); //JwtFilter를
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class); //Security로직에 필터를 등록
    }
}
