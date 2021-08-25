package com.fund.capture.biz.tiantian.start;

import com.fund.capture.basic.constant.Constant;
import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import com.fund.capture.basic.table.mapper.FundBaseInfoMapper;
import com.fund.capture.basic.table.mapper.FundDetailInfoMapper;
import com.fund.capture.biz.tiantian.service.FundCaptureService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public class FundDetailInfoCapture {

    @Resource
    private FundBaseInfoMapper fundBaseInfoMapper;

    @Resource
    private FundDetailInfoMapper fundDetailInfoMapper;

    @Resource
    private FundCaptureService fundCaptureService;

    @Async
    public void initFundDetailInfo() {
        List<FundBaseInfo> fundBaseInfoList = fundBaseInfoMapper.selectAll();
        fundBaseInfoList.forEach(fundBaseInfo -> {
            captureFundDetailInfoToNewestDay(fundBaseInfo);
        });
    }

    @Transactional
    public void captureFundDetailInfoToNewestDay(FundBaseInfo fundBaseInfo) {
        List<FundDetailInfo> fundDetailInfoList = fundCaptureService.queryFundDetailInfoList(fundBaseInfo.getFcode(), fundBaseInfo.getDetailDataDate());
        int size = fundDetailInfoList.size();
        for (int i = size - 1; i >= 0; i--) {
            FundDetailInfo fundDetailInfo = fundDetailInfoList.get(i);
            String fsrq = fundDetailInfo.getFsrq();
            try {
                Date var1 = Constant.sdf.parse(fundBaseInfo.getDetailDataDate());
                Date var2 = Constant.sdf.parse(fsrq);
                if (var2.after(var1)) {
                    fundDetailInfoMapper.insertSelective(fundDetailInfo);
                    fundBaseInfo.setDetailDataDate(fsrq);
                    fundBaseInfoMapper.updateByPrimaryKey(fundBaseInfo);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
