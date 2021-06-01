package com.zhuanget.wavelengthexplore;

import com.alibaba.fastjson.JSON;
import com.zhuanget.wavelengthexplore.entity.FaceBelongDetailDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Zhuang_ET
 * @since 2021-01-13 17:42:16
 */
@Slf4j
public class GlobalTest {

    public static void main(String[] args) {
        String ss = "sdfkdsdsk";
        String[] ks = ss.split("k");

        int res = compareVersion("0.1", "1.1");
        log.info("res: {}", res);
    }

    public static int compareVersion(String version1, String version2) {
        String[] sp1 = version1.split("\\.");
        String[] sp2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int len1 = sp1.length;
        int len2 = sp2.length;
        while(i < len1 || j < len2) {
            int num1 = 0;
            int num2 = 0;
            if(i < len1) {
                num1 = Integer.parseInt(sp1[i]);
            }
            if(j < len2) {
                num2 = Integer.parseInt(sp2[j]);
            }
            if(num1 == num2) {
                i++;
                j++;
            } else if(num1 < num2) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
