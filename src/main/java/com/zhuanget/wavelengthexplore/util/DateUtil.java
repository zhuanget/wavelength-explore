package com.zhuanget.wavelengthexplore.util;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static final String FORMAT_YMD = "yyyy-MM-dd";
    public static final String FORMAT_YYMMDD = "yyyyMMdd";
    public static final String FORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YMD_HMS_S = "yyy-MM-dd HH:mm:ss.S";

    public static final String DAY_BEGIN_TIME_SUFFIX = " 00:00:00";
    public static final String DAY_END_TIME_SUFFIX = " 23:59:59";

    public static final Long MILLIS_PER_SECOND = 1000L;

    public static final DateTimeFormatter DTF_YMD = DateTimeFormatter.ofPattern(FORMAT_YMD, Locale.CHINA);
    public static final DateTimeFormatter DTF_YYMMDD = DateTimeFormatter.ofPattern(FORMAT_YYMMDD, Locale.CHINA);
    public static final DateTimeFormatter DTF_YMD_HMS = DateTimeFormatter.ofPattern(FORMAT_YMD_HMS, Locale.CHINA);
    public static final DateTimeFormatter DTF_YMD_HMS_S = DateTimeFormatter.ofPattern(FORMAT_YMD_HMS_S, Locale.CHINA);
    public static Date parseStringToDate(String strDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
