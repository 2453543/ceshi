package com.ysj.blms.domain;

import lombok.Data;

import java.util.Date;

/**
 * @TableName sportsnews
 */
@Data
public class Sportsnews {
    private Integer newsid;

    private String title;

    private String content;

    private Date publishtime;

    private String source;
}