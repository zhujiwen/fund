package com.fund.capture.basic.table.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class FundBaseInfo implements Serializable {
    private static final Long SerialVersionUID = 1L;

    @Id
    private Integer id;
    private String fcode;
    private String shortName;
    private String detailDataDate;

}
