package com.fund.capture.tiantian.capture;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fund.capture.tiantian.bean.FundDetailInfo;
import com.fund.capture.tiantian.bean.FundDetailInfoUrl;
import com.fund.capture.util.HttpUtils;
import netscape.javascript.JSObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抓取某基金详细信息
 */
public class FundDetailInfoCapture {

    /**
     * 获取资金的详细信息
     *
     * @return
     */
    public List<FundDetailInfo> queryFundDetailInfoList(String fundCode) {
        List<FundDetailInfo> fundDetailInfoList = new ArrayList<>();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Referer", "http://fundf10.eastmoney.com/");
        FundDetailInfoUrl fundDetailInfoUrl = new FundDetailInfoUrl();
        fundDetailInfoUrl.replaceFundCode(fundCode);
        fundDetailInfoUrl.replacePageIndex("1");
        fundDetailInfoUrl.replacePageSize("200");
        fundDetailInfoUrl.replaceTime1(String.valueOf(System.currentTimeMillis() - 5));
        fundDetailInfoUrl.replaceTime(String.valueOf(System.currentTimeMillis()));
        String url = fundDetailInfoUrl.getUrl();
        String s = HttpUtils.sendGet(url, headerMap);
        JSONArray lsjzList = JSONObject.parseObject(s).getJSONObject("Data").getJSONArray("LSJZList");
        for (Object o : lsjzList) {
            String s1 = JSONObject.toJSONString(o);
            FundDetailInfo fundDetailInfo = JSONObject.parseObject(s1, FundDetailInfo.class);
            fundDetailInfoList.add(fundDetailInfo);
        }
        return fundDetailInfoList;
    }
}