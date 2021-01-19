package com.zhuanget.wavelengthexplore.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Zhuang_ET
 * @since 2021-01-19 14:15:24
 */
@Data
public class CarEventInfoDTO {

    private String sourceId;

    private String type;

    private String tid;

    private String plateColor;

    private String id;

    private String smallUrl;

    private String guid;

    private String fromImageId;

    private String plateNumber;

    private String bigUrl;

    private Date time;
}
