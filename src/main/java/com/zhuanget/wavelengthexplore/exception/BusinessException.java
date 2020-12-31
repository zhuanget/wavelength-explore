package com.zhuanget.wavelengthexplore.exception;

/**
 * 业务异常通用类
 * @author Zhuang_ET
 * @since 2020-09-30 10:30:27
 */
public class BusinessException extends RuntimeException{

    public BusinessException() {

    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
