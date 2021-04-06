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

    public static int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        if(x < 4) {
            return 1;
        }
        if(x < 9) {
            return 2;
        }
        if(x < 16) {
            return 3;
        }
        int low = 4;
        int high = x / 4;
        while(low < high) {
            int mid = (low + high) / 2;
            if(mid * mid == x) {
                return mid;
            } else if(mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(low > high) {
            return low - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int res = mySqrt(8192);
        System.out.println("max: " + (int)Math.sqrt(Integer.MAX_VALUE));
    }
}
