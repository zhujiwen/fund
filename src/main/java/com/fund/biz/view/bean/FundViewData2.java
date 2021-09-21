package com.fund.biz.view.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FundViewData2 {
    private String fundName;
    private String fundCode;
    private Double max;
    private Double min;
    private List<String> fsrq = new ArrayList<>();
    private List<String> dwjz = new ArrayList<>();
}
