package com.fund.storage.mysql;

import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import com.fund.capture.basic.table.mapper.FundBaseInfoMapper;
import com.fund.capture.basic.table.mapper.FundDetailInfoMapper;
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
