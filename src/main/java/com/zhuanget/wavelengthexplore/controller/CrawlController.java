package com.zhuanget.wavelengthexplore.controller;

import com.zhuanget.wavelengthexplore.service.CrawlService;
import com.zhuanget.wavelengthexplore.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/crawl")
public class CrawlController {

    @Autowired
    private CrawlService crawlService;

    @GetMapping("/data")
    public BaseResponse crawData(@RequestParam(value = "type") String type) {
        return crawlService.crawlDataByType(type);
    }

    @GetMapping("/download")
    public BaseResponse downloadPics(@RequestParam(value = "type") String type) {
        return crawlService.downloadPictures(type);
    }
}
