package com.zhuanget.wavelengthexplore.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CarArchivesInfoDto {

    private Long id;

    private String plateNumber;

    private String plateType;

    private String plateColor;

    private String type;

    private String color;

    private String brandCode;

    @JsonProperty(value = "brand")
    @JSONField(name = "brand")
    private String brandName;

    @JsonProperty(value = "smallUrl")
    @JSONField(name = "smallUrl")
    private String smallImage;

    private String smallImageId;

    private String sourceId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;

    private String bigUrl;

    private String fromImageId;

    private Integer count;

    private String sourceType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 静态库名称,对应t_static_db中bank_ename字段
     */
    private List<String> bankNameList;

    /**
     * 该档案是否被关注
     */
    private Boolean follow = false;

    /**
     * 该车辆档案所属车主
     */
    private String realName;

    /**
     * 该车牌所属地(本地车辆，本省车辆，外地车辆)
     */
    private String localPlateType;
}
