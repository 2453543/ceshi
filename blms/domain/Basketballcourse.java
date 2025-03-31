package com.ysj.blms.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName basketballcourse
 */
@Data
public class Basketballcourse {
    private Integer courseid;
    private String coursename;
    private String description;
    private Integer coachid;
    private String coachname;
    private String venueid;
    private Date starttime;
    private Date endtime;
    private BigDecimal price;
    private Integer maxstudents;
    private Integer enrolledstudents;
    private Integer isactive;
    private Object status;
    private String starttimeStr;
    private String endtimeStr;
}