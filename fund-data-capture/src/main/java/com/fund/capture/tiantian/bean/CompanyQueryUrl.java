package com.fund.capture.tiantian.bean;

/**
 * 按照开头关键字查找公司
 */
public class CompanyQueryUrl {
    private String key;
    private String time;
    private String url = "https://fundsuggest.eastmoney.com/FundSearch/api/FundSearchAPI.ashx?m=1&key=" + key + "&_= " + time;

    /**
     * @param key (A-Z)
     */
    public CompanyQueryUrl(String key) {
        this.key = key;
        String time = String.valueOf(System.currentTimeMillis());
        this.time = time;
    }

    /**
     * @param key (A-Z)
     * @param time 时间戳
     */
    public CompanyQueryUrl(String key, String time) {
        this.key = key;
        this.time = time;
    }

    public String getUrl(){
        return this.url;
    }
}
