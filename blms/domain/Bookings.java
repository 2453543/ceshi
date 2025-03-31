package com.ysj.blms.domain;

import java.util.Date;
import lombok.Data;

/**
 * @TableName bookings
 */
@Data
public class Bookings {
    private Integer bookingid;

    private Integer userid;

    private String courtnumber;

    private Date bookingdate;

    private Date starttime;

    private Date endtime;

    private Object bookingstatus;

    private String bookingdateStr;

    private String starttimeStr;

    private String endtimeStr;
}