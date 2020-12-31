package com.zhuanget.wavelengthexplore.exception;

/**
 * 未授权异常类
 * @author Zhuang_ET
 * @since 2020-09-30 10:38:08
 */
public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException() {

    }

    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
