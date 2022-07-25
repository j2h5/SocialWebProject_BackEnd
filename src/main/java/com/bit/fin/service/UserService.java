package com.bit.fin.service;

import java.util.*;

import com.bit.fin.dto.ClassDto;
import com.bit.fin.dto.UserDto;
import com.bit.fin.entity.Authority;
import com.bit.fin.entity.User;
import com.bit.fin.mapper.UserMapper;
import com.bit.fin.repository.UserRepository;
import com.bit.fin.util.SecurityUtil;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    // UserService는 위의 2개를 주입받음
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // signup 메서드는 회원가입 로직을 수행하는 메서드
    @Transactional
    public UserDto signup(UserDto userDto) {
        //파라미터로 받은 userDto안에 Username을 기준으로 해서 저장되어있는 정보가 있는지 찾아보고!!
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        // 없으면 권한정보를 생성
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        // 위의 권한정보를 포함한 user 정보를 생성해서
        User user = User.builder()
                .username(userDto.getUsername())
                .realname(userDto.getRealname())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .profile(userDto.getProfile())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        // userRepository의 save메서드를 통해서 db에 정보를 저장
        return UserDto.from(userRepository.save(user));
    }

    //  ----------아래는 유저와 권한정보를 가져오는 메서드 2개


    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) {
        // username을 파라미터로 받아서 어떠한 username이든 해당 정보와 권한정보를 가져오는 것
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        // 현재 SecurityContext에 저장되어있는 정보만 가져올 수 있음
        return UserDto.from(SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElse(null));
    }

    public int usernameCheck(String username) {
        return userMapper.usernameCheck(username);
    }

    public int emailCheck(String email) {
        return userMapper.emailCheck(email);
    }

    public UserDto getProfile(String username) {
        return userMapper.getProfile(username);
    }

    public void insertProfile(UserDto dto) {
        userMapper.insertProfile(dto);
    }

    public int loginCheck(String username, String password){
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        return userMapper.loginCheck(map);
    };

    public UserDto findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    public void changePassword(UserDto dto) {userMapper.changePassword(dto);}

    public UserDto findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    //임시비밀번호로 변경
    public void imsiPassword(String username, String password){
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        userMapper.imsiPassword(map);
    };

}
