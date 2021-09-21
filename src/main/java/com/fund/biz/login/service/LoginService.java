package com.fund.biz.login.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    public Map<String, Object> login(String username, String pwd) {
        Map<String, Object> resultMap = new HashMap<>();
        return resultMap;
    }

    public Map<String, Object> logout(String username) {
        Map<String, Object> resultMap = new HashMap<>();
        return resultMap;
    }
}
