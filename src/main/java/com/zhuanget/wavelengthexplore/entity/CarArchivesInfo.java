package com.zhuanget.wavelengthexplore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车辆档案
 * </p>
 *
 * @author Zhuang_ET
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_car_archives_info")
public class CarArchivesInfo extends Model<CarArchivesInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 车牌类型
     */
    private String plateType;

    /**
     * 车牌颜色
     */
    private String plateColor;

    /**
     * 车类型
     */
    private String type;

    /**
     * 车颜色
     */
    private String color;

    /**
     * 品牌code
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 抓拍url
     */
    private String smallImage;

    /**
     * 摄像头id
     */
    private String sourceId;

    /**
     * 更新时间
     */
    private Date time;

    /**
     * 小图id
     */
    private String smallImageId;

    /**
     * 大图url
     */
    private String bigUrl;

    /**
     * 大图id
     */
    private String fromImageId;

    /**
     * 来源类型
     */
    private String sourceType;

    /**
     * 次数
     */
    private Integer count;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 静态库名称
     */
    private String bankName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
