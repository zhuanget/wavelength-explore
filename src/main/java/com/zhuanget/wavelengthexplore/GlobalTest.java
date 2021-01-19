package com.zhuanget.wavelengthexplore;

import com.alibaba.fastjson.JSON;
import com.zhuanget.wavelengthexplore.entity.FaceBelongDetailDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Zhuang_ET
 * @since 2021-01-13 17:42:16
 */
@Slf4j
public class GlobalTest {

    public static void main(String[] args) {
        FaceBelongDetailDTO faceBelongDetailDTO = new FaceBelongDetailDTO()
                .setBizCode("matrix").setCarGuid("123131")
                .setCarNo("粤B123456").setCarSourceId("12")
                .setPersonTime(new Date());
        log.info("faceBelongDetail: {}", JSON.toJSONString(faceBelongDetailDTO));
    }
}
