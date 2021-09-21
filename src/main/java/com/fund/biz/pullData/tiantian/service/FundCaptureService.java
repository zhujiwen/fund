package com.fund.biz.pullData.tiantian.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fund.basic.table.bean.FundBaseInfo;
import com.fund.basic.table.bean.FundDetailInfo;
import com.fund.basic.util.HttpUtils;
import com.fund.basic.util.Utils;
import com.fund.biz.pullData.tiantian.bean.FundDetailInfoUrl;
import com.fund.biz.pullData.tiantian.bean.FundQueryUrl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FundCaptureService {

    /**
     * 根据公司开头关键字(A-Z)查询该关键字对应的所有公司的所有基金基本信息
     *
     * @param key (A-Z)
     */
    public String captureFundBaseInfoList(String key) {
        FundQueryUrl fundQueryUrl = new FundQueryUrl(key);
        String fundInfo = HttpUtils.sendGet(fundQueryUrl.getUrl());
        return fundInfo;
    }

    /**
     * 获取所有的基金基本信息
     */
    public List<FundBaseInfo> captureAllFundBaseInfoList(){
        List<FundBaseInfo> fundBaseInfoList = new ArrayList<>();
        Utils utils = new Utils();
        List<String> atoZ = utils.getAtoZ();
        for (String curValue : atoZ) {
            String fundInfo = captureFundBaseInfoList(curValue);
            JSONObject fundJson = JSON.parseObject(fundInfo);
            JSONArray datas = fundJson.getJSONArray("Datas");
            if (datas == null){
                continue;
            }
            for (Object data : datas) {
                JSONObject t1 = (JSONObject) data;
                JSONArray qxjj = t1.getJSONArray("QXJJ");
                for (int i = 0; i < qxjj.size(); i++) {
                    JSONObject qxjjJSONObject = qxjj.getJSONObject(i);
                    String fcode = qxjjJSONObject.getString("FCODE");
                    String shortName = qxjjJSONObject.getString("SHORTNAME");
                    FundBaseInfo fundBaseInfo = new FundBaseInfo();
                    fundBaseInfo.setFcode(fcode);
                    fundBaseInfo.setShortName(shortName);
                    fundBaseInfoList.add(fundBaseInfo);
                }
            }
        }
        return fundBaseInfoList;
    }

    /**
     * 获取自某天开始该资金的详细信息(包含startDate)
     *
     * @return
     */
    public List<FundDetailInfo> queryFundDetailInfoList(String fundCode,String startDate) {
        List<FundDetailInfo> fundDetailInfoList = new ArrayList<>();
        Map<String, String> headerMap = new HashMap<>();
        long l = LocalDate.now().toEpochDay() - LocalDate.parse(startDate).toEpochDay();
        System.out.println(l);
        headerMap.put("Referer", "http://fundf10.eastmoney.com/");
        FundDetailInfoUrl fundDetailInfoUrl = new FundDetailInfoUrl();
        fundDetailInfoUrl.replaceFundCode(fundCode);
        fundDetailInfoUrl.replacePageIndex("1");
        fundDetailInfoUrl.replacePageSize(String.valueOf(l+1));
        fundDetailInfoUrl.replaceTime1(String.valueOf(System.currentTimeMillis() - 5));
        fundDetailInfoUrl.replaceTime(String.valueOf(System.currentTimeMillis()));
        String url = fundDetailInfoUrl.getUrl();
        String s = HttpUtils.sendGet(url, headerMap);
        JSONArray lsjzList = JSONObject.parseObject(s).getJSONObject("Data").getJSONArray("LSJZList");
        for (Object o : lsjzList) {
            String s1 = JSONObject.toJSONString(o);
            FundDetailInfo fundDetailInfo = JSONObject.parseObject(s1, FundDetailInfo.class);
            fundDetailInfo.setFcode(fundCode);
            fundDetailInfoList.add(fundDetailInfo);
        }
        return fundDetailInfoList;
    }
}