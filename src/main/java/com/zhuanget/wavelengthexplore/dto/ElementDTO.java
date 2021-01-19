package com.zhuanget.wavelengthexplore.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Zhuang_ET
 * @since 2021-01-04 19:04:00
 */
@Data
@Accessors(chain = true)
public class ElementDTO implements Serializable {

    private static final long serialVersionUID = 2915921070305706884L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 元素
     */
    private String element;
    /**
     * 离子态
     */
    private String ion;
    /**
     * 观察波长，单位nm，真空环境
     */
    private Double observedWavelength;
    /**
     * 里兹波长，单位nm，真空环境
     */
    private Double ritzWavelength;
}
