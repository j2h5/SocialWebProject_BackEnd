package com.bit.fin.service;

import com.bit.fin.dto.MailDto;
import com.bit.fin.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Properties;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    // 메일 내용을 생성하고 임시 비밀번호로 회원 비밀번호를 변경
    public MailDto createMailAndChangePassword(String email) {

        String str = getTempPassword();

        MailDto dto = new MailDto();

        dto.setAddress(email);
        dto.setTitle("[ 오늘,한강 ] 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. [ 오늘,한강 ] 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 "
                + str + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");
        updatePassword(str,email);
        return dto;
    }

    //랜덤함수로 임시비밀번호 구문 만들기
    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        //임시 비밀번호 리턴
        return str;
    }

    // 메일보내기
    public void mailSend(MailDto dto) {
        System.out.println("전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getAddress());
        message.setSubject(dto.getTitle());
        message.setText(dto.getMessage());
        message.setFrom("todayhangang@naver.com");
        message.setReplyTo("todayhangang@naver.com");
        System.out.println("message"+message);
        mailSender.send(message);
    }

    //임시 비밀번호로 업데이트
    public void updatePassword(String str, String email){

        //임시 비밀번호 암호화
        String password = passwordEncoder.encode(str);
        String username = userService.findByEmail(email).getUsername();
        userService.imsiPassword(username,password);
    }

    //실제 비밀번호 변경 쿼리문 요청
//    public void updatePassword1(UserDto dto){
//        userService.changePassword(dto);
//    }
}
