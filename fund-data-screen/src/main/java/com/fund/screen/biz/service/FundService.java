package com.fund.screen.biz.service;

import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import com.fund.capture.basic.table.mapper.FundBaseInfoMapper;
import com.fund.capture.basic.table.mapper.FundDetailInfoMapper;
import com.fund.screen.basic.custom.Custom1;
import com.fund.screen.biz.util.ViewUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        FundBaseInfo fundBaseInfoVar1 = new FundBaseInfo();
        for (FundBaseInfo fundBaseInfo : fundBaseInfoList) {
            fundBaseInfoVar1.setFcode(fundBaseInfo.getFcode());
            //todo
        }
        List<FundDetailInfo> fundDetailInfoList = custom1.queryFundDetailInfoList(start, size);
        return resultMap;
    }

    /**
     * 获取某只基金的某段时间历史数据
     */
    public Map<String, Object> queryFundHistory(int fcode, Date startDate, Date endDate) {
        Map<String, Object> resultMap = new HashMap<>();
        FundDetailInfo fundDetailInfo = new FundDetailInfo();
        fundDetailInfo.setFcode(fcode);

        Example example = new Example(FundDetailInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fcode", fcode);//相当于 where name = "王小二"
        criteria.andBetween("fsrq", startDate, endDate);
        List<FundDetailInfo> fundDetailInfoList = fundDetailInfoMapper.selectByExample(example);
        log.info("size===={}", fundDetailInfoList.size());
        resultMap.put("code", 1);
        resultMap.put("data", fundDetailInfoList);
        return resultMap;
    }
}
