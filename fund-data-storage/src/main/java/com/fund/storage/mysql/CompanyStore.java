package com.fund.storage.mysql;

import com.fund.storage.bean.Company;
import com.fund.storage.mapper.CompanyMapper;
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
