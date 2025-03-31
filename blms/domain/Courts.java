package com.ysj.blms.domain;

import lombok.Data;

/**
 * @TableName courts
 */
@Data
public class Courts {
    private Integer courtid;

    private String courtnumber;

    private Object courttype;

    private Integer capacity;

    private String state;

}