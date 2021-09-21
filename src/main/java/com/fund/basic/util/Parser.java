package com.fund.basic.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fund.basic.table.bean.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {
    public List<Company> parseCompanyJson(String companyJson){
        List<Company> companyList = new ArrayList<>();
        JSONArray datas = JSONObject.parseObject(companyJson).getJSONArray("Datas");
        if (datas == null){
            return companyList;
        }
        int dataSize = datas.size();
        for (int i = 0; i < dataSize; i++) {
            JSONObject var1 = datas.getJSONObject(i);
            String jjgsid = var1.getString("JJGSID");
            String jjgs = var1.getString("JJGS");
            Company company = new Company();
            company.setId(Long.valueOf(jjgsid));
            company.setName(jjgs);
            companyList.add(company);
        }
        return companyList;
    }
}
