package com.bit.fin.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//username - token 값을 로그인 시 저장하는 MAP(내 jvm서버 메모리에 저장)
public class InMemoryTokenStore {
    private Map<String, String> tokenStore = new HashMap();

    public Map<String, String> getTokenStore() {
        return tokenStore;
    }

    public void setTokenStore(String username, String token) {
        this.tokenStore.put(username,token);
    }

    //로그아웃 시 username에 해당하는 token 삭제
    public void removeToken(String username){
        this.tokenStore.remove(username);

    }
}
