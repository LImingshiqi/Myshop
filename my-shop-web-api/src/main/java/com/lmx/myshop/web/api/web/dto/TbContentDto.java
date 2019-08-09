package com.lmx.myshop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LMX on 2019/7/30 17:20
 */

@Data
public class TbContentDto implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
