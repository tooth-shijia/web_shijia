package com.shijia.web.controller.user.viewmodel;

/**
 * @author YanxiSir
 * @since 17/2/23
 */
public class BaseDTO {


    public static final String HOME = "home";
    public static final String SHIJIA = "shijia";
    public static final String BEIYI = "beiyi";
    public static final String NEWS = "news";
    public static final String ABOUT = "about";
    public static final String CONTACT = "contact";

    public static final String HOME_TITLE = "首页";
    public static final String SHIJIA_TITLE = "世佳产品";
    public static final String BEIYI_TITLE = "贝艺数字产品";
    public static final String NEWS_TITLE = "新闻动态";
    public static final String ABOUT_TITLE = "关于世佳";
    public static final String CONTACT_TITLE = "联系我们";

    /**
     * 首页-home
     * 世佳产品-shijia
     * 贝艺产品-beiyi
     * 新闻动态-news
     * 关于世佳-about
     * 联系我们-contact
     */
    private String curPage = HOME;

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }
}
