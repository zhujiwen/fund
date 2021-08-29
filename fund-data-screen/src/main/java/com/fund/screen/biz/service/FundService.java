package com.fund.screen.biz.service;

import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import com.fund.capture.basic.table.mapper.FundBaseInfoMapper;
import com.fund.capture.basic.table.mapper.FundDetailInfoMapper;
import com.fund.screen.basic.custom.Custom1;
import com.fund.screen.biz.util.ViewUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FundService {

    @Resource
    private FundBaseInfoMapper fundBaseInfoMapper;

    @Resource
    private FundDetailInfoMapper fundDetailInfoMapper;

    @Resource
    private Custom1 custom1;

    @Resource
    private ViewUtil viewUtil;

    /**
     * 获取基金数量
     */
    public Map<String, Object> queryFundSize() {
        Map<String, Object> resultMap = new HashMap<>();
        int fundSize = fundBaseInfoMapper.selectCount(null);
        resultMap.put("code", 1);
        resultMap.put("data", fundSize);
        return resultMap;
    }

    /**
     * 批量查询基金的详细信息
     *
     */
    public Map<String, Object> queryNFundDetailInfoList(int start, int size,String startDate) {
        Map<String, Object> resultMap = new HashMap<>();
        List<FundBaseInfo> fundBaseInfoList = custom1.queryFundBaseInfoList(start, size);
        FundBaseInfo fundBaseInfoVar1 = new FundBaseInfo();
        for (FundBaseInfo fundBaseInfo : fundBaseInfoList) {
            fundBaseInfoVar1.setFcode(fundBaseInfo.getFcode());
            //todo
        }
        List<FundDetailInfo> fundDetailInfoList = custom1.queryFundDetailInfoList(start, size);
        return resultMap;
    }


}
