package com.ysj.blms.domain;

import lombok.Data;

import java.util.Date;

/**
 * @TableName announcements
 */
@Data
public class Announcements {
    private Integer announcementId;

    private String title;

    private String content;

    private Date publishtime;

    private Integer publisherid;
}