package com.bit.fin.service;

//import com.bit.fin.mapper.UserMapper;
//import com.bit.fin.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//    private final UserMapper userMapper;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userMapper = userMapper;
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(final String username) {
//        // 로그인 시에 DB에서 유저정보와 권한 정보를 가져오게 됨
//        return userMapper.findOneWithAuthoritiesByUsername(username)
//                .map(user -> createUser(username, user))// db에서 가져온 정보를 기반으로!
//                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
//    }
//
//    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
//        if (!user.isActivated()) {  // 그 user가 활성화 상태라면?!
//            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
//        }
//        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
//                .collect(Collectors.toList());
//        // username, password, 권한정보를 가지고 User객체를 return 해주게 됨
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(),
//                grantedAuthorities);
//    }
//}
