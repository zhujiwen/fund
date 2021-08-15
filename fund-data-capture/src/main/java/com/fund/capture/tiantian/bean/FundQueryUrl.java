package com.fund.capture.tiantian.bean;

/**
 * 按照开头关键字查找所有的资金
 */
public class FundQueryUrl {
    private String key;
    private String time;
    private String url;

    /**
     * @param key (A-Z)
     */
    public FundQueryUrl(String key) {
        this.key = key;
        String time = String.valueOf(System.currentTimeMillis());
        this.time = time;
        url = "https://fundsuggest.eastmoney.com/FundSearch/api/FundSearchAPI.ashx?m=3&key=" + key + "&_=" + time;
    }

    /**
     * @param key (A-Z)
     * @param time 时间戳
     */
    public FundQueryUrl(String key, String time) {
        this.key = key;
        this.time = time;
        url = "https://fundsuggest.eastmoney.com/FundSearch/api/FundSearchAPI.ashx?m=3&key=" + key + "&_= " + time;
    }

    public String getUrl(){
        return this.url;
    }
}
