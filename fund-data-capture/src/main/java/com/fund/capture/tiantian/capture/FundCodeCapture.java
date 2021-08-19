package com.fund.capture.tiantian.capture;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fund.capture.tiantian.bean.FundBaseInfo;
import com.fund.capture.tiantian.bean.FundQueryUrl;
import com.fund.capture.util.HttpUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 抓取基金代码数据
 */
public class FundCodeCapture {

    /**
     * 获取所有的基金基本信息
     */
    public List<FundBaseInfo> captureAllFundBaseInfoList(){
        List<FundBaseInfo> fundBaseInfoList = new ArrayList<>();
        List<String> atoZ = getAtoZ();
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
                    int id = Integer.parseInt(qxjjJSONObject.getString("_id"));
                    int fcode = Integer.parseInt(qxjjJSONObject.getString("FCODE"));
                    String shortName = qxjjJSONObject.getString("SHORTNAME");
                    FundBaseInfo fundBaseInfo = new FundBaseInfo(id, fcode, shortName);
                    fundBaseInfoList.add(fundBaseInfo);
                }
            }
        }
        return fundBaseInfoList;
    }

    /**
     * 根据公司开头关键字(A-Z)查询所有的基金基本信息
     *
     * @param key (A-Z)
     */
    public String captureFundBaseInfoList(String key) {
        FundQueryUrl fundQueryUrl = new FundQueryUrl(key);
        String fundInfo = HttpUtils.sendGet(fundQueryUrl.getUrl());
        return fundInfo;
    }

    private List<String> getAtoZ(){
        List<String> aToZ = new ArrayList<>();
        char value = 'A';
        for (int i = 0; i < 26; i++) {
            aToZ.add(String.valueOf(value++));
        }
        return aToZ;
    }


}
