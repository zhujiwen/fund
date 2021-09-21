package com.fund.basic.table.bean;


import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Purchase implements Serializable {

  private static final long serialVersionUID = -1956807315697612460L;

  @Id
  private Long id;

  private String userName;

  private Long fcode;

}
