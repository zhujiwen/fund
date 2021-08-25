package com.fund.capture.biz.tiantian.controller;

import com.fund.capture.basic.table.bean.FundDetailInfo;
import com.fund.capture.biz.tiantian.service.FundCaptureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FundCaptureController {
    @Resource
    private FundCaptureService fundCaptureService;

    @ResponseBody
    @RequestMapping(path = "/queryFundDetailInfoList",method = RequestMethod.GET)
    public void queryFundDetailInfoList(){
        List<FundDetailInfo> fundDetailInfos = fundCaptureService.queryFundDetailInfoList("000134","2021-08-24");
        fundDetailInfos.forEach(System.out::println);
    }
}
