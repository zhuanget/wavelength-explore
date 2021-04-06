package com.zhuanget.wavelengthexplore.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应天图ES索引bigdata_archive_body的实体类
 *
 * 2021-02-19: 改动：对应bigdata_body_event的实体类
 *
 * @author Zhuang_ET
 * @since 2020-09-21 20:51:45
 */
@Data
@Accessors(chain = true)
public class BodyEventDTO implements Serializable {

    private static final long serialVersionUID = 2822215898053163517L;

    private String id;

    private String aid;

    @JSONField(name = "thumbnail_id")
    private String thumbnailId;

    @JSONField(name = "create_time")
    private Long createTime;

    private String version;

    @JSONField(name = "source_id")
    private String sourceId;

    @JSONField(name = "target_rect")
    private String targetRect;

    @JSONField(name = "thumbnail_url")
    private String thumbnailUrl;

    @JSONField(name = "source_type")
    private String sourceType;

    @JSONField(name = "image_id")
    private String imageId;

    private String gender;

    @JSONField(name = "image_url")
    private String imageUrl;

    @JSONField(name = "img_quality")
    private String imgQuality;

    @JSONField(name = "target_type")
    private String targetType;

    @JSONField(name = "relation_id")
    private String relationId;

    @JSONField(name = "area_id")
    private String areaId;

    private Long time;

    @JSONField(name = "body_bike_relationid")
    @JsonProperty(value = "body_bike_relationid")
    private String bodyBikeRelationId;

    private Long dt;

    private String latlon;

    @JSONField(name = "face_body_relationid")
    @JsonProperty(value = "face_body_relationid")
    private String faceBodyRelationId;

    @JSONField(name = "is_delete")
    private Integer isDelete;

    @JSONField(name = "track_id")
    private String trackId;

    @JSONField(name = "body_integrity")
    private String bodyIntegrity;
}
