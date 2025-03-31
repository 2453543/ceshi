package com.ysj.blms.domain;

import lombok.Data;

/**
 * @TableName users
 */
@Data
public class Users {
    private Integer userid;

    private String useridname;

    private String username;

    private String phone;

    private String email;

    private Object usertype;
}