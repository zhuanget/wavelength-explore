package com.zhuanget.wavelengthexplore.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 * @author Zhuang_ET
 * @since 2020-12-31 11:18:12
 */
@RestController("/test")
@RequestMapping("/test")
public class TestController {

    @GetMapping("/print")
    public String test() {
        return "success";
    }
}
