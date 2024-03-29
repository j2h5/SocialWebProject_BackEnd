package com.bit.fin.controller;

import com.bit.fin.config.InMemoryTokenStore;
import com.bit.fin.dto.AuthorityDto;
import com.bit.fin.dto.MailDto;
import com.bit.fin.dto.UserDto;
import com.bit.fin.mapper.UserMapper;
import com.bit.fin.repository.UserRepository;
import com.bit.fin.service.CustomUserDetailsService;
import com.bit.fin.service.MailService;
import com.bit.fin.service.UserService;
import com.bit.fin.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    
    @GetMapping("/getprofile2")
    public UserDto getProfile2(@RequestParam String username) { 

    	return userService.getProfile2(username);
    	}

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

    //아이디존재유무 확인
    @GetMapping("/idchk")
    public int idchk(@RequestParam String username){
        int result = userService.idCheck(username);
        return result;
    }

    //로그인 시 아이디로 비밀번호 일치 여부 확인
    @PostMapping("/loginchk")
    public int loginCheck(@RequestBody UserDto dto ) throws Exception
    {
        UserDto user = userService.findByUsername(dto.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(encoder.matches(dto.getPassword(), user.getPassword())){
            return 1;
    }else
        return 0; //모두 맞으면 1, 틀리면 0 반환
    }

    //비밀번호 변경
    @PostMapping("/passchange")
    public void passChange(@RequestBody UserDto dto ){

        //암호화 필요
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        userService.changePassword(dto);
    }

    //메일 보내기
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody UserDto dto){
        MailDto maildto = mailService.createMailAndChangePassword(dto.getEmail());
        mailService.mailSend(maildto);
    }

    //회원 탈퇴하기
    @GetMapping("/deleteuser")
    public void deleteUser(@RequestParam int user_id){
        // 먼저 USER_Authority Table의 row 삭제하기
        userService.deleteUserAuth(user_id);
        userService.deleteUser(user_id);
    }
    // 닉네임(realname)변경
    @PostMapping("/nickchange")
    public void changeNick(@RequestBody UserDto dto){
        userService.changeNick(dto);
    }

    @GetMapping("/getauth")
    public int getAuthority(@RequestParam String user_id){ return userService.getAuth(user_id);}

}