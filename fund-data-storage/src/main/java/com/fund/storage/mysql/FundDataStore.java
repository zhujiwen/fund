package com.fund.storage.mysql;

import com.fund.storage.bean.FundBaseInfo;
import com.fund.storage.bean.FundDetailInfo;
import com.fund.storage.mapper.FundBaseInfoMapper;
import com.fund.storage.mapper.FundDetailInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FundDataStore {
    @Autowired
    private FundBaseInfoMapper fundBaseInfoMapper;

    @Autowired
    private FundDetailInfoMapper fundDetailInfoMapper;

    public void storeFundBaseInfoList(List<FundBaseInfo> fundBaseInfoList) {
        fundBaseInfoList.forEach(fundBaseInfo -> {
            fundBaseInfoMapper.insert(fundBaseInfo);
        });
    }

    public void storeFundDetailInfoList(List<FundDetailInfo> fundDetailInfoList) {
        fundDetailInfoList.forEach(fundDetailInfo -> {
            fundDetailInfoMapper.insert(fundDetailInfo);
        });
    }
}
