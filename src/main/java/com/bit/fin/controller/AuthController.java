package com.bit.fin.controller;

import com.bit.fin.dto.LoginDto;
import com.bit.fin.dto.TokenDto;
import com.bit.fin.jwt.JwtFilter;
import com.bit.fin.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        // 파라미터로 받은 LoginDTo의 username과 password를 통해서 authenticationToken를 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        //authenticationToken을 이용해서 .authenticate 메서드가 실행이 될 때 customUserDetailsService에서  loadUserByUSername 메서드가 실행됨\
        // 그러면 아래 authentication 객체가 생성됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // authentication객체를 securityContext에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //위정보를 기반으로 Token을 생성
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        //jwt 토큰을 Header에 넣어주기
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        //jwt 토큰을 ResponseBody에도  넣어서 리턴
        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}

