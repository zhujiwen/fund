package com.fund.capture.basic.table.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundDetailInfo implements Serializable {
  private static final Long SerialVersionUID = 1L;

  private Long id;
  private Long fcode;
  private String fsrq;
  private String dwjz;
  private String ljjz;
  private String jzzzl;
}
