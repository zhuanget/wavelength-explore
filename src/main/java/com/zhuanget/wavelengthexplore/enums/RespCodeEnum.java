package com.zhuanget.wavelengthexplore.enums;

/**
 * 状态码枚举
 *
 * @author Zhuang_ET
 * @since 2020-09-29 19:33:47
 */
public enum RespCodeEnum {

    SUCCESS("10000", "success"),
    BUSINESS_ERROR("20001", "业务错误"),
    COMMON_EXCEPTION("20002", "通用异常"),
    NOT_AUTHORIZED("30001", "未授权"),
    ;

    private String respCode;

    private String respMessage;

    RespCodeEnum(String respCode, String respMessage) {
        this.respCode = respCode;
        this.respMessage = respMessage;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }
}
