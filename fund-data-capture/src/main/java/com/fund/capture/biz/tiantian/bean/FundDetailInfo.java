package com.fund.capture.biz.tiantian.bean;

import lombok.Data;

@Data
public class FundDetailInfo {
    /**
     * 净值日期
     */
    private String FSRQ;

    /**
     * 单位净值
     */
    private String DWJZ;

    /**
     * 累计净值
     */
    private String LJJZ;

    /**
     * 日增长率
     */
    private String JZZZL;

}
