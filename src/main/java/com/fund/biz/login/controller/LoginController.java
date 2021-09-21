package com.fund.biz.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/login")
@Slf4j
public class LoginController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public Map<String, Object> login() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", -1);
            resultMap.put("desc", "系统错误");
            log.error("用户登陆发生错误:{}", e);
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/logout")
    public Map<String, Object> logout() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", -1);
            resultMap.put("desc", "系统错误");
            log.error("用户退出登陆发生错误:{}", e);
        }
        return resultMap;
    }
}
