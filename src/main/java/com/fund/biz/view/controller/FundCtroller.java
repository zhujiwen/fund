package com.fund.biz.view.controller;

import com.fund.basic.constant.Constant;
import com.fund.biz.view.service.FundService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fund")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class FundCtroller {

    @Resource
    private FundService fundService;

    /**
     * 获取基金数量
     */
    @ResponseBody
    @RequestMapping(path = "/queryFundSize", method = RequestMethod.GET)
    public Map<String, Object> queryFundSize() {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            return fundService.queryFundSize();
        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
        }
        return resultMap;
    }

    /**
     * 批量查询基金的详细信息
     */
    @ResponseBody
    @RequestMapping(path = "/queryNFundDetailInfoList", method = RequestMethod.POST)
    public Map<String, Object> queryNFundDetailInfoList(@RequestBody Map<String, String> requestMap) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            int start = Integer.parseInt(requestMap.get("start"));
            int size = Integer.parseInt(requestMap.get("size"));
            String startDate = requestMap.get("startDate");
            if (startDate == null) {
                LocalDate today = LocalDate.now();
                startDate = String.valueOf(today.minusDays(180));
            }
            return fundService.queryNFundDetailInfoList(start, size, startDate);
        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("desc", "系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 获取某只基金的某段时间历史数据
     */
    @ResponseBody
    @RequestMapping(value = "/queryFundHistory", method = RequestMethod.POST)
    public Map<String, Object> queryFundHistory(@RequestBody Map<String, String> requestMap) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String fcode = requestMap.get("fcode");
            Date startDate = Constant.sdf.parse(requestMap.get("startDate"));
            Date endDate = Constant.sdf.parse(requestMap.get("endDate"));
            return fundService.queryFundHistory(fcode, startDate, endDate);
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
