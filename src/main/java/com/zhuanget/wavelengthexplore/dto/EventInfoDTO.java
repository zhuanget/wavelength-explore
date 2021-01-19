package com.zhuanget.wavelengthexplore.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Zhuang_ET
 * @since 2021-01-19 14:10:40
 */
@Data
public class EventInfoDTO {

    private Integer imageCount;

    private String devId;

    private String sourceId;

    private String imageId;

    private String faceId;

    private String devName;

    private String geoString;

    private Date dt;

    private String faceUrl;

    private String personFilesId;

    private String sourceType;

    private String targetRect;

    private String imageUrl;

    private String id;

    private Date snapTime;

    private Date snapDate;
}
