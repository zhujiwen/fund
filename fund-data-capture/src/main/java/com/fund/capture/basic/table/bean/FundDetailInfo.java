package com.fund.capture.basic.table.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class FundDetailInfo implements Serializable {
  private static final Long SerialVersionUID = 1L;

  @Id
  private Long id;
  private Integer fcode;
  private String fsrq;
  private String dwjz;
  private String ljjz;
  private String jzzzl;
}
