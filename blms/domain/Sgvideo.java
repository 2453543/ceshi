package com.ysj.blms.domain;

import java.util.Date;
import lombok.Data;

/**
 * @TableName sgvideo
 */
@Data
public class Sgvideo {
    private Integer id;

    private String title;

    private String cover;

    private String origin;

    private String url;

    private Date createtime;

    private Date updatetime;

    private String createtimeStr;

    private String updatetimeStr;
}