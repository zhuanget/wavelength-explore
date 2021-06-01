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
 * 档案信息历史表
 * </p>
 *
 * @author Zhuang_ET
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_archive_info_history")
public class ArchiveInfoHistory extends Model<ArchiveInfoHistory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 人员档案ID【编号】（可重复）
     */
    private String aid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件类型  0:身份证  1:港澳通行证  2:护照  3:港澳居民来往内地通行证  4:台湾居民来往大陆通行证  5:其它
     */
    private Integer cidType;

    /**
     * 证件号码
     */
    private String cid;

    /**
     * 证件有效期
     */
    private Date cidExpireDate;

    /**
     * 签发机关
     */
    private String issuingAuthority;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 性别(1-男， 2-女, 0-未知)
     */
    private Integer gender;

    /**
     * 年龄: 0 未知 （备注：只是作为一种参考值）
     */
    private Integer age;

    /**
     * 档案户籍所在地
     */
    private String residenceAddr;

    /**
     * 居住地
     */
    private String currAddr;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 手机mac地址
     */
    private String phoneMac;

    /**
     * 交通工具
     */
    private String transportation;

    /**
     * 交通卡
     */
    private String transportationCard;

    /**
     * 最近抓拍时间
     */
    private Date recentSnapTime;

    /**
     * 抓拍照片数
     */
    private Integer imageCount;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 算法版本
     */
    private Integer algoVersion;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 是否删除(0-未删除，1-已删除)
     */
    private Integer isDeleted;

    /**
     * 档案来源
     */
    private String sourceType;

    /**
     * 公司地址
     */
    private String companyAddr;

    /**
     * 民族
     */
    private String nation;

    /**
     * 所属单位
     */
    private String organization;

    /**
     * 实名状态
     */
    private Integer checkState;

    /**
     * 抽象库id
     */
    private String bankId;

    /**
     * 抽象库英文名称
     */
    private String bankEname;

    /**
     * 抽象库人员id
     */
    private String bankArchiveId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
