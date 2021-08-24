package com.fund.screen.biz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testController")
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String test(){
        return "hello world";
    }
}
