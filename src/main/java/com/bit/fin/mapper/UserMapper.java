package com.bit.fin.mapper;

import com.bit.fin.dto.UserDto;

import java.util.List;
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
    public UserDto getProfile(String username); // 해당 아이디의 프로필 사진, realname 가져오기
    public void insertProfile(UserDto dto); // 회원가입 시 프로필 사진 따로 저장&변경
    public int loginCheck(Map<String, String> map); // 로그인 시 아디,비번 일치여부 확인
    public UserDto findByUsername(String username); //username으로 DTO정보 전부 불러오기
    public void changePassword(UserDto dto); // 비밀번호 변경
    public UserDto findByEmail(String email); //email으로 DTO정보 전부 불러오기(메일)
    public void imsiPassword(Map<String, String> map); //임시비밀번호로 변경
    public void deleteUserAuth(int user_id); //회원 권한 삭제하기
    public void deleteUser(int user_id); // 회원 탈퇴하기
    public void changeNick(UserDto dto); //회원 닉네임 변경
}
