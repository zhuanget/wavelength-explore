package com.zhuanget.wavelengthexplore.vo;

import com.zhuanget.wavelengthexplore.enums.RespCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 19:25:07
 */
@Data
@AllArgsConstructor
public class BaseResponse {

    private String respCode;

    private String respMessage;

    private String respRemark;

    private Object data;

    private long maxPage;

    private long total;

    public BaseResponse() {

    }

    public BaseResponse(RespCodeEnum respCodeEnum) {
        this(respCodeEnum.getRespCode(), respCodeEnum.getRespMessage(), respCodeEnum.getRespMessage(), null, 0L, 0L);
    }

    public BaseResponse(Object data) {
        this(RespCodeEnum.SUCCESS.getRespCode(), RespCodeEnum.SUCCESS.getRespMessage(), "", data, 0L, 0L);
    }

    public BaseResponse(Object data, long maxPage, long total) {
        this(RespCodeEnum.SUCCESS.getRespCode(), RespCodeEnum.SUCCESS.getRespMessage(), "", data, maxPage, total);
    }

    public BaseResponse(String respCode, String respMessage, String respRemark) {
        this(respCode, respMessage, respRemark,  null, 0L, 0L);
    }

    public static BaseResponse success(Object data) {
        return new BaseResponse(data);
    }
}
