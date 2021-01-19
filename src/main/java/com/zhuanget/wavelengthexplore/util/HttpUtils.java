package com.zhuanget.wavelengthexplore.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Http 请求工具类 （重新引入，避免调用天图实时分析接口时，出现超时熔断）
 *
 * @author yeyunxi
 * @since 2019/9/22 10:08
 */
@Component
@Slf4j
public class HttpUtils {

	private static int readTimeout = 0;
    private static int connectTimeout = 0;
    private static int connectRetries = 0;

	@Value("${http.read.timeout:600000}")
	public void setReadTimeout(Integer readTimeout) {
		HttpUtils.readTimeout = readTimeout;
	}

    @Value("${http.connect.timeout:3000}")
    public void setConnectTimeout(Integer connectTimeout) {
        HttpUtils.connectTimeout = connectTimeout;
    }

    @Value("${http.connect.retries:3}")
    public void setConnectRetries(Integer connectRetries) {
        HttpUtils.connectRetries = connectRetries;
    }

	private HttpUtils() {}

    public static String doGetJson(Map<String, String> requestHeaderMap, String targetUrl) {
        if (requestHeaderMap == null) {
            requestHeaderMap = new HashMap<>();
        }
        return doGet(requestHeaderMap, targetUrl);
    }

	public static String doPostJson(Map<String, String> requestHeaderMap, String targetUrl, String requestBody) {
		if (requestHeaderMap == null) {
			requestHeaderMap = new HashMap<>();
		}
		requestHeaderMap.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return doPost(requestHeaderMap, targetUrl, requestBody);
	}

	public static String doPostForm(Map<String, String> requestHeaderMap, String targetUrl, String requestBody) {
		if (requestHeaderMap == null) {
			requestHeaderMap = new HashMap<>();
		}
		requestHeaderMap.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		return doPost(requestHeaderMap, targetUrl, requestBody);
	}

    private static String doGet(Map<String, String> requestHeaderMap, String targetUrl) {
        long httpRequestStart = System.currentTimeMillis();
        StringBuilder responseBody = new StringBuilder();
        StringBuilder errorBody = new StringBuilder();
        BufferedReader reader = null;
        HttpURLConnection urlConnection = null;

        try {
            int retry = connectRetries;
            while (retry > 0) {
                try {
                    URL url = new URL(targetUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(connectTimeout);
                    urlConnection.setReadTimeout(readTimeout);
                    urlConnection.setUseCaches(false);
                    if (requestHeaderMap != null) {
                        for (Map.Entry entry : requestHeaderMap.entrySet()) {
                            urlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    urlConnection.connect();
                    break;
                } catch (Exception e) {
                    log.error("连接失败：url = {}, error = {}", targetUrl, e.getMessage());
                }
                retry--;
            }

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpStatus.OK.value()) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }
            } else {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    errorBody.append(line);
                }
                log.error("http请求返回异常，状态码为{}，错误信息为{}", responseCode, errorBody.toString());
            }

        } catch (Exception e) {
            log.error("http请求期间出错，错误信息为：{}", e);

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("关闭reader时出错，错误信息为{}", e.getMessage());
                } finally {
                    reader = null;
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        log.info("本次http请求的URL为{}，共耗时{}ms", targetUrl, (System.currentTimeMillis() - httpRequestStart));
        return responseBody.toString();
    }

	private static String doPost(Map<String, String> requestHeaderMap, String targetUrl, String requestBody) {
		long httpRequestStart = System.currentTimeMillis();
		StringBuilder responseBody = new StringBuilder();
		StringBuilder errorBody = new StringBuilder();
		BufferedReader reader = null;
		HttpURLConnection urlConnection = null;
		OutputStream outputStream = null;

		try {
			int retry = connectRetries;
			while (retry > 0) {
			    try {
                    URL url = new URL(targetUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("POST");
                    urlConnection.setConnectTimeout(connectTimeout);
                    urlConnection.setReadTimeout(readTimeout);
                    urlConnection.setDoOutput(true);
                    urlConnection.setDoInput(true);
                    urlConnection.setUseCaches(false);
                    if (requestHeaderMap != null) {
                        for (Map.Entry entry : requestHeaderMap.entrySet()) {
                            urlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    urlConnection.connect();
                    break;
                } catch (Exception e) {
			        log.error("连接失败：url = {}, error = {}", targetUrl, e.getMessage());
                }
                retry--;
            }

			outputStream = urlConnection.getOutputStream();
			outputStream.write(requestBody.getBytes());

			int responseCode = urlConnection.getResponseCode();
			if (responseCode == HttpStatus.OK.value()) {
				reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					responseBody.append(line);
				}
			} else {
				reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					errorBody.append(line);
				}
				log.error("http请求返回异常，状态码为{}，错误信息为{}", responseCode, errorBody.toString());
			}

		} catch (Exception e) {
			log.error("http请求期间出错，错误信息为：{}", e);

		} finally {
		    try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Exception e1) {
                log.error("关闭reader时出错，错误信息为{}", e1.getMessage());
            } finally {
                outputStream = null;
                reader = null;
                urlConnection = null;
            }
		}

		log.info("本次http请求的URL为{}，共耗时{}ms", targetUrl, (System.currentTimeMillis() - httpRequestStart));
		return responseBody.toString();
	}
}
