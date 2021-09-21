package com.fund.biz.pullData.mysql;

import com.fund.basic.table.bean.Company;
import com.fund.basic.table.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 存储基金公司的数据到Mysql
 */
public class CompanyStore {
    @Autowired
    private CompanyMapper companyMapper;

    public void saveCompanyData(List<Company> companyList){
        companyList.forEach(company -> companyMapper.insert(company));
    }


}
