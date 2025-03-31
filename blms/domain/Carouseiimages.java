package com.ysj.blms.domain;

import lombok.Data;

/**
 * @TableName carouseiimages
 */
@Data
public class Carouseiimages {
    private Integer imagetd;

    private String imagepath;

    private String link;

    private Integer displayorder;

    private Integer isactive;
}