package com.fund.basic.table.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class Company implements Serializable {
    private static final Long SerialVersionUID = 1L;

    private Long id;
    private String name;

}
