package com.fund.capture.biz.tiantian;

import com.fund.capture.basic.table.bean.Company;
import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.mapper.CompanyMapper;
import com.fund.capture.basic.table.mapper.FundBaseInfoMapper;
import com.fund.capture.basic.util.Parser;
import com.fund.capture.basic.util.Utils;
import com.fund.capture.biz.tiantian.service.FundCaptureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TiantianApplicationRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(TiantianApplicationRunner.class);

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private Utils utils;

    @Resource
    private Parser parser;

    @Resource
    private FundCaptureService fundCaptureService;

    @Resource
    private FundBaseInfoMapper fundBaseInfoMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initCompanyData();
        initFundBaseInfo();
    }

    private void initCompanyData(){
        logger.info("开始查询本地是否包含公司的数据");
        List<Company> companies = companyMapper.selectAll();
        if (companies.size() == 0) {
            logger.info("开始采集公司数据");
            List<String> atoZ = utils.getAtoZ();
            atoZ.forEach(letter -> {
                String fundBaseInfoList = fundCaptureService.captureFundBaseInfoList(letter);
                List<Company> companyList = parser.parseCompanyJson(fundBaseInfoList);
                companyList.forEach(company -> companyMapper.insert(company));
                logger.info("{}的数据采集完毕",letter);
            });
            logger.info("采集公司数据完毕");
        }
    }

    private void initFundBaseInfo(){
        List<FundBaseInfo> fundBaseInfos = fundBaseInfoMapper.selectAll();
        if (fundBaseInfos.size() != 0){
            logger.info("数据库已经存在了资金的数据，不会再次采集");
            return;
        }
        logger.info("开始采集所有基金的数据");
        List<FundBaseInfo> fundBaseInfoList = fundCaptureService.captureAllFundBaseInfoList();
        fundBaseInfoList.forEach(fundBaseInfo -> {
            fundBaseInfoMapper.insert(fundBaseInfo);;
            System.out.println(fundBaseInfo);
        });
        logger.info("基金数据采集完毕");
    }
}
