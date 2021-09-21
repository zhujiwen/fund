package com.fund.biz.view.bean;

import com.fund.basic.table.bean.FundDetailInfo;
import lombok.Data;

import java.util.List;

@Data
public class FundViewData {
    private String fundName;
    private String fundCode;
    private List<FundDetailInfo> fundDetailInfo;
}
