package com.bit.fin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    private SecurityUtil() {
    }

    // getCurrentUsername 메서드는 Security Context의 Authentication 객체를 이용해 username을 리턴해주는 간단한 유틸성 메서드
    public static Optional<String> getCurrentUsername() {
        // SecurityContext에서 getAuthentication를 꺼내와서,  ( ** DoFilter 메서드에서 저장되어 있음)
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication 객체를 통해서 username을 리턴해주는 간단한유틸성 메서드
        if (authentication == null) {
            logger.debug("Security Context에 인증 정보가 없습니다.");
            return Optional.empty();
        }

        String username = null;
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            username = springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            username = (String) authentication.getPrincipal();
        }

        return Optional.ofNullable(username);
    }
}
