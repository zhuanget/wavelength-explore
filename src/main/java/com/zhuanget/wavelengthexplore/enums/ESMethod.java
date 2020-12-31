package com.zhuanget.wavelengthexplore.enums;

/**
 * ES方法枚举类
 * @author Zhuang_ET
 * @since 2020-09-29 17:09:12
 */
public enum ESMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    ;

    private String method;

    public String getMethod() {
        return method;
    }

    ESMethod(String method) {
        this.method = method;
    }
}
