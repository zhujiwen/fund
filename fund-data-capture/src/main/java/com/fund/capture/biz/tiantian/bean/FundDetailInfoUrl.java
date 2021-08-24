package com.fund.capture.biz.tiantian.bean;

public class FundDetailInfoUrl {
    private String url = "http://api.fund.eastmoney.com/f10/lsjz?fundCode={fundCode}" +
            "&pageIndex={pageIndex}&pageSize={pageSize}&startDate=&endDate=&_={time}";

    public void replaceFundCode(String fundCode) {
        url = url.replace("{fundCode}", fundCode);
    }

    public void replaceTime1(String time){
        url = url.replace("{time_1}",time);
    }

    public void replacePageIndex(String pageIndex) {
        url = url.replace("{pageIndex}", pageIndex);
    }

    public void replacePageSize(String pageSize){
        url = url.replace("{pageSize}",pageSize);
    }

    public void replaceTime(String time){
        url = url.replace("{time}",time);
    }

    public String getUrl(){
        return url;
    }

}
