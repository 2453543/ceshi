package com.ysj.blms.domain;

import lombok.Data;

import java.util.Date;

/**
 * @TableName equipmentlistst
 */
@Data
public class Equipmentlistst {
    private String borrowingid;

    private String userid;

    private String equipmentid;

    private Date borrowdate;

    private Date returndate;

    private Object borrowingstatus;

    private String borrowdateStr;

    private String returndateStr;


}