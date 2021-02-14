package com.zhuanget.wavelengthexplore.service;

import com.zhuanget.wavelengthexplore.vo.BaseResponse;

public interface CrawlService {

    BaseResponse crawlDataByType(String type);

    BaseResponse downloadPictures(String type);
}
