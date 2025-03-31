package com.ysj.blms.domain;

import lombok.Data;

import java.util.Date;

/**
 * @TableName administrators
 */
@Data
public class Administrators {
    private Integer adminid;

    private String adminname;

    private String password;

    private String email;

    private String phonenumber;

    private Date createtime;

    private Date lastlogintime;
}