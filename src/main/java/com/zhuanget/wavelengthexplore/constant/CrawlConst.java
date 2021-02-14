package com.zhuanget.wavelengthexplore.constant;

public class CrawlConst {

    private CrawlConst() {
    }

    public static final String BASE_URL = "https://www.jianshu.com";
    public static final String ARTICLE_URL = "https://www.jianshu.com/p/\\w+";

    public static final String TITLE = "title";
    public static final String USER = "user";
    public static final String IMAGE_URLS = "imageUrls";
    public static final String IMAGE_URL = "imageUrl";
    public static final String USER_HOME = "userHome";

    // NIST查询
    public static final String DATABASE_URL = "https://physics.nist.gov/PhysRefData/ASD/lines_form.html";
    public static final String SPECTRA_URL_PRE = "https://physics.nist.gov/cgi-bin/ASD/lines1.pl?spectra=";
    public static final String SPECTRA_URL_SUF = "&limits_type=0&low_w=&upp_w=&unit=1&submit=Retrieve+Data&de=0&format=0&line_out=0&en_unit=0&output=0&bibrefs=1&page_size=15&show_obs_wl=1&show_calc_wl=1&unc_out=1&order_out=0&max_low_enrg=&show_av=2&max_upp_enrg=&tsb_value=0&min_str=&A_out=0&intens_out=on&max_str=&allowed_out=1&forbid_out=1&min_accur=&min_intens=&conf_out=on&term_out=on&enrg_out=on&J_out=on";

    // 元素周期表
    public static final String[] PERIODIC_TABLE = new String[]{"H", "He", "Li", "Be", "B", "C", "N", "O", "F",
            "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar",
            "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br",
            "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Te", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te",
            "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm",
            "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn",
            "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr",
            "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og", "Uue"};
}
