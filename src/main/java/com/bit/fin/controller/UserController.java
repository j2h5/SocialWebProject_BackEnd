package com.bit.fin.controller;

import com.bit.fin.config.InMemoryTokenStore;
import com.bit.fin.dto.UserDto;
import com.bit.fin.mapper.UserMapper;
import com.bit.fin.service.CustomUserDetailsService;
import com.bit.fin.service.UserService;
import com.bit.fin.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private InMemoryTokenStore inMemoryTokenStore;

    @Autowired
    UserMapper mapper;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/test-redirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/user");
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        //userdto를 파라미터로 받아서 UserService의 signup 메서드 수행
        return ResponseEntity.ok(userService.signup(userDto));
    }

    //아이디 중복확인
    @GetMapping("/usernamecheck")
    public int usernameCheck(@RequestParam String username)
    {
        return userService.usernameCheck(username);
    }

    //이메일 중복확인
    @GetMapping("/emailcheck")
    public int emailcheck(@RequestParam String email)
    {
        return userService.emailCheck(email);
    }

    //해당아이디 데이터 불러오기
    @GetMapping("/getprofile")
    public UserDto getProfile(@RequestParam String username) { return userService.getProfile(username);}

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // getMyUserInfo 메서드는 @PreAuthorize를 통해서 User과 admin 두가지 권한을 모두 호출할 수 있는 api
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    // getMyUserInfo 메서드는 @PreAuthorize를 통해서 admin 권한만 호출할 수 있는 api
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username));
    }


    //프로필 사진 업로드 관련
    String photoName; //리액트에서 업로드한 이미지명(변경)된 이미지명 일수도

    //리액트에서 이미지 업로드시 save폴더에 저장후 이미지명 반환
    @PostMapping("/upload")
    public String fileUpload(@RequestParam MultipartFile uploadFile,
                             HttpServletRequest request)
    {
        //파일명
        String fileName=uploadFile.getOriginalFilename();
        System.out.println("fileName="+fileName);

        //업로드할 폴더 위치
        String path=request.getServletContext().getRealPath("/save");

        //직전에 업로드한 이미지 삭제하기
        File file=new File(path+"/"+photoName);

        // 만약 존재할 경우 삭제
        if(file.exists())
            file.delete();

        //파일명 변경
        FileUtil fileUtil=new FileUtil();
        photoName=fileUtil.changeFileName(fileName);


        //save폴더에 업로드
        try {
            uploadFile.transferTo(new File(path+"/"+photoName));
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return photoName;
    }

    //회원 가입 시 프로필 사진 넣기
    @PostMapping("/instprf")
    public void insert(@RequestBody UserDto dto, String jwt)
    {
        dto.setProfile(photoName);
        userService.insertProfile(dto);
        photoName=null;
    }

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserDetailsService userDetailsService;

    //로그인 시 아이디, 비밀번호 일치 여부 확인
    @PostMapping("/loginchk")
    public int loginCheck(@RequestBody UserDto dto ) throws Exception
    {
        UserDto user = userService.findByUsername(dto.getUsername());
        System.out.println("user = " + user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(encoder.matches(dto.getPassword(), user.getPassword())){
            System.out.println("비밀번호 일치");
            return 1;
    }else
        System.out.println("비밀번호 불일치");
        return 0; //모두 맞으면 1, 틀리면 0 반환
    }
    
}