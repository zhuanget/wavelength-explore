package com.zhuanget.wavelengthexplore.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件表结构实体类，对应天谱ES索引：matrix_event_multi
 *
 * @author Zhuang_ET
 * @since 2021-02-01 20:27:49
 */
@Data
public class EventMultiDTO implements Serializable {

    private static final long serialVersionUID = -5564958829008107413L;
    /**
     * 去重复主键
     */
    private String id;
    /**
     * 档案id
     */
    private String aid;
    /**
     * 业务侧该实体唯一标识
     */
    private String dataCode;
    /**
     * 事件类型
     */
    private String dataType;
    /**
     * 所属业务编码
     */
    private String bizCode;
    /**
     * 采集时间的时间戳
     */
    private Long time;
    /**
     * 采集日期的时间戳
     */
    private Long collDt;
    /**
     * 采集点位信息
     */
    private String location;
    /**
     * 组合id
     */
    private String guid;
    /**
     * 创建日期的时间戳
     */
    private Date createTime;
    /**
     * 最后更新时间的时间戳
     */
    private Date modifyTime;
    /**
     * 来源渠道
     */
    private String sysCode;
    /**
     * 扩展属性信息
     */
    private String props;
}
