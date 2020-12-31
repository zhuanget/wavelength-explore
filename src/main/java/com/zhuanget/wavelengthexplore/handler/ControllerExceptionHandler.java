package com.zhuanget.wavelengthexplore.handler;


import com.zhuanget.wavelengthexplore.enums.RespCodeEnum;
import com.zhuanget.wavelengthexplore.exception.BusinessException;
import com.zhuanget.wavelengthexplore.exception.NotAuthorizedException;
import com.zhuanget.wavelengthexplore.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * controller异常捕获
 *
 * @author Zhuang_ET
 * @since 2020-09-30 10:29:33
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * 未授权异常处理，状态码401
     * @param ex
     * @return
     */
    @ExceptionHandler(value = NotAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public BaseResponse handleNotAuthorizedException(NotAuthorizedException ex) {
        log.error("用户信息获取失败，e: ", ex);
        return new BaseResponse(RespCodeEnum.NOT_AUTHORIZED);
    }

    /**
     * 业务异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BaseResponse handleBusinessException(BusinessException e) {
        log.error("业务异常，e：", e);
        return new BaseResponse(RespCodeEnum.BUSINESS_ERROR);
    }

    /**
     * 通用异常处理，其他异常类在其上面
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleCommonException(Exception e) {
        log.error("通用异常，e：", e);
        return new BaseResponse(RespCodeEnum.COMMON_EXCEPTION);
    }

    /**
     * throwable抛出异常处理，其他异常类在其上面
     * @param th
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public BaseResponse handleThrowable(Throwable th) {
        log.error("throwable通用异常，e：", th);
        return new BaseResponse(RespCodeEnum.COMMON_EXCEPTION);
    }
}
