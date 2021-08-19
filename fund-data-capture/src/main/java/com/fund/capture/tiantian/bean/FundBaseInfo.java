package com.fund.capture.tiantian.bean;

public class FundBaseInfo {
    /**
     * id(与fcode相同)
     */
    private int id;

    /**
     * 基金code
     */
    private int fcode;

    /**
     * 基金名称
     */
    private String shortName;

    public FundBaseInfo(int id, int fcode, String shortName) {
        this.id = id;
        this.fcode = fcode;
        this.shortName = shortName;
    }
}
