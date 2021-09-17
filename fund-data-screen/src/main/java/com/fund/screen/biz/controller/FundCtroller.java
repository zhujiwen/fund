package com.fund.screen.biz.controller;

import com.fund.screen.basic.custom.Custom1;
import com.fund.screen.biz.util.ViewUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fund")
public class FundCtroller {

    @Resource
    private Custom1 custom1;


    /**
     * 获取基金数量
     */
    public Map<String, Object> queryFundSize() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }

    /**
     * 批量查询基金的详细信息
     */
    public Map<String, Object> queryFundDetailInfoList() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }

    /**
     * 获取某只基金的某段时间历史数据
     */
    public Map<String, Object> queryFundHistory() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }

    /**
     * 收藏某基金
     */
    public Map<String, Object> collectFund() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }

    /**
     * 购买某基金
     */
    public Map<String, Object> buyFund() {
        Map<String, Object> resultMap = new HashMap<>();
        try {

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }
}
