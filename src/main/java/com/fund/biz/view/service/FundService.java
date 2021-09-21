package com.fund.biz.view.service;

import com.fund.basic.custom.Custom1;
import com.fund.basic.table.bean.FundBaseInfo;
import com.fund.basic.table.bean.FundDetailInfo;
import com.fund.basic.table.mapper.FundBaseInfoMapper;
import com.fund.basic.table.mapper.FundDetailInfoMapper;
import com.fund.biz.view.bean.FundViewData;
import com.fund.biz.view.bean.FundViewData2;
import com.fund.biz.view.util.ViewUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
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
     */
    public Map<String, Object> queryNFundDetailInfoList(int start, int size, String startDate) {
        Map<String, Object> resultMap = new HashMap<>();
        List<FundBaseInfo> fundBaseInfoList = custom1.queryFundBaseInfoList(start, size);
        List<FundViewData2> historyList = new ArrayList<>();
        for (FundBaseInfo fundBaseInfo : fundBaseInfoList) {
            List<FundDetailInfo> fundDetailInfosHistoryList = custom1.queryFundDetailInfoListByStartDate(fundBaseInfo.getFcode(), startDate);
            FundViewData2 fundViewData = new FundViewData2();
            fundViewData.setFundCode(fundBaseInfo.getFcode());
            fundViewData.setFundName(fundBaseInfo.getShortName());
            for (FundDetailInfo fundDetailInfo : fundDetailInfosHistoryList) {
                fundViewData.getDwjz().add(fundDetailInfo.getDwjz());
                fundViewData.getFsrq().add(fundDetailInfo.getFsrq());
            }
            if (!fundViewData.getDwjz().isEmpty()){
                fundViewData.setMax(Double.valueOf(Collections.max(fundViewData.getDwjz())));
                fundViewData.setMin(Double.valueOf(Collections.min(fundViewData.getDwjz())));
            }
            historyList.add(fundViewData);
        }
        resultMap.put("code", 1);
        resultMap.put("data", historyList);
        return resultMap;
    }

    /**
     * 获取某只基金的某段时间历史数据
     */
    public Map<String, Object> queryFundHistory(String fcode, Date startDate, Date endDate) {
        Map<String, Object> resultMap = new HashMap<>();
        FundDetailInfo fundDetailInfo = new FundDetailInfo();
        fundDetailInfo.setFcode(fcode);

        Example example = new Example(FundDetailInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fcode", fcode);
        criteria.andBetween("fsrq", startDate, endDate);
        List<FundDetailInfo> fundDetailInfoList = fundDetailInfoMapper.selectByExample(example);
        log.info("size===={}", fundDetailInfoList.size());
        resultMap.put("code", 1);
        resultMap.put("data", fundDetailInfoList);
        return resultMap;
    }
}
