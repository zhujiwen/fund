package com.fund.storage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundBaseInfo implements Serializable {
    private static final Long SerialVersionUID = 1L;

    private Long id;
    private Long fcode;
    private String shortName;

}
