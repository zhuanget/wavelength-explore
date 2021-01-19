package com.zhuanget.wavelengthexplore.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 天谱matrix_car_event_face_belong实体类
 *
 * @author Zhuang_ET
 * @since 2021-01-15 14:26:03
 */
@Data
@Accessors(chain = true)
public class FaceBelongDetailDTO {
    /**
     * 业务码
     */
    @JSONField(name = "biz_code")
    private String bizCode;
    /**
     * 车辆guid
     */
    @JSONField(name = "car_guid")
    private String carGuid;
    /**
     * 车牌号
     */
    @JSONField(name = "car_no")
    private String carNo;
    /**
     * 车辆摄像头ID
     */
    @JSONField(name = "car_sourceid")
    @JsonProperty(value = "car_sourceid")
    private String carSourceId;
    /**
     * 车辆抓拍小图ID
     */
    @JSONField(name = "car_thumbnail_id")
    private String carThumbnailId;
    /**
     * 车辆抓拍小图URL
     */
    @JSONField(name = "car_thumbnail_url")
    private String carThumbnailUrl;
    /**
     * 车辆抓拍时间
     */
    @JSONField(name = "car_time")
    private Date carTime;
    /**
     * 碰撞时间
     */
    @JSONField(name = "coll_dt")
    private Date collDt;
    /**
     * 数据类型
     */
    @JSONField(name = "data_type")
    private String dataType;
    /**
     * 人员档案ID
     */
    @JSONField(name = "person_aid")
    private String personAid;
    /**
     * 人员guid
     */
    @JSONField(name = "person_guid")
    private String personGuid;
    /**
     * 人员大图ID
     */
    @JSONField(name = "person_image_id")
    private String personImageId;
    /**
     * 人员大图URL
     */
    @JSONField(name = "person_image_url")
    private String personImageUrl;
    /**
     * 人员抓拍分数
     */
    @JSONField(name = "person_score")
    private String personScore;
    /**
     * 人员抓拍摄像头ID
     */
    @JSONField(name = "person_sourceid")
    @JsonProperty(value = "person_sourceid")
    private String personSourceId;
    /**
     * 人员抓拍小图ID
     */
    @JSONField(name = "person_thumbnail_id")
    private String personThumbnailId;
    /**
     * 人员抓拍小图URL
     */
    @JSONField(name = "person_thumbnail_url")
    private String personThumbnailUrl;
    /**
     * 人员抓拍时间
     */
    @JSONField(name = "person_time")
    private Date personTime;
}
