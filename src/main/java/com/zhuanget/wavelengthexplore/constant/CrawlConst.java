package com.zhuanget.wavelengthexplore.constant;

public class CrawlConst {

    private CrawlConst() {}

    public static final String BASE_URL = "https://www.jianshu.com";
    public static final String ARTICLE_URL = "https://www.jianshu.com/p/\\w+";

    public static final String TITLE = "title";
    public static final String USER = "user";
    public static final String IMAGE_URLS = "imageUrls";
    public static final String IMAGE_URL = "imageUrl";
    public static final String USER_HOME = "userHome";

    // NIST查询
    public static final String DATABASE_URL = "https://physics.nist.gov/PhysRefData/ASD/lines_form.html";

    public static final String SEARCH_URL_PREFIX = "https://physics.nist.gov/cgi-bin/ASD/lines1.pl?spectra=";
    public static final String SEARCH_URL_SUFFIX ="&limits_type=0&low_w=&upp_w=&unit=1&submit=Retrieve+Data&de=0&format=0&line_out=0&en_unit=0&output=0&bibrefs=1&page_size=15&show_obs_wl=1&show_calc_wl=1&unc_out=1&order_out=0&max_low_enrg=&show_av=2&max_upp_enrg=&tsb_value=0&min_str=&A_out=0&intens_out=on&max_str=&allowed_out=1&forbid_out=1&min_accur=&min_intens=&conf_out=on&term_out=on&enrg_out=on&J_out=on";
}
