package com.zhuanget.wavelengthexplore.dto;

import com.zhuanget.wavelengthexplore.entity.CarArchivesInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Linzhi.Wang
 * @version V1.0
 * @Title: CarArchivesReq.java
 * @Package com.intellif.ifaas.api.dto.consumer.req
 * @Description
 * @date 2019 12-16 9:19.
 */
@Data
public class CarArchivesReq extends CarArchivesInfo implements Serializable {
	private static final long serialVersionUID = 8080446338713340313L;

	private List<Long> ids;

    private List<String> plateNumbers;

	private Integer page=1;

	private Integer pageSize=10;

	private String bankEName;

	private String personName;

	private String carColor;

	private String personCid;

	private String personPhone;

	private String carVisaOffice;

	private String carVisaDate;

	private String carNo;

	private String carType;

	private Long userId;

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String custom5;
	private String custom6;
	private String custom7;
	private String custom8;
	private String custom9;
	private String custom10;


	/**
	 * 排序转换为字符串
	 */
	private String orderStr;

	/**
	 * 本地车牌(粤B),本省车辆(粤)
	 */
	private String carPlateNumber;

	/**
	 * 外省车辆
	 */
	private String outLocationNumber;

	/**
	 * 图片搜索
	 */
	private List<String> imageSearchCarNumber;

	/**
	 * 车辆品牌列表
	 */
	private List<String> brandCodeList;

	/**
	 * 车辆红名单
	 */
	private List<String> redPlateNumbers;

}
