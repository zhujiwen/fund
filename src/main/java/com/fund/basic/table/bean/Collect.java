package com.fund.basic.table.bean;


import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Collect implements Serializable {
    private static final long serialVersionUID = -994517353645351524L;

    @Id
    private Long id;
    private String userName;
    private Long fcode;

}
