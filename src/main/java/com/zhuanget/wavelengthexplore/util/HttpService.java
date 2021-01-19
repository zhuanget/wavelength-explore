package com.zhuanget.wavelengthexplore.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Http 请求封装服务 （重新引入，避免调用天图实时分析接口时，出现超时熔断）
 *
 * @author yeyunxi
 * @since 2019/9/22 10:17
 */

public class HttpService {

    private HttpService() {}

    public static <T> T sendHttpJsonGet(Map<String, String> headerMap, String url, Class<T> returnType) {
        String result = HttpUtils.doGetJson(headerMap, url);
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        return JSON.parseObject(result, returnType);
    }

    public static <S, T> T sendHttpJsonPost(Map<String, String> headerMap, String url, S body, Class<T> returnType) {
        String bodyStr = JSON.toJSONString(body);
        String result = HttpUtils.doPostJson(headerMap, url, bodyStr);
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        return JSON.parseObject(result, returnType);
    }
}