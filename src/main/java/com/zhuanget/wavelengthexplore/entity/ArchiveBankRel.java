package com.zhuanget.wavelengthexplore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 天图档案与库人员关联表
 * </p>
 *
 * @author Zhuang_ET
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_archive_bank_rel")
public class ArchiveBankRel extends Model<ArchiveBankRel> {

    private static final long serialVersionUID = 1L;

    /**
     * 人员档案ID【编号】
     */
    private String aid;

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
        return this.aid;
    }

}
