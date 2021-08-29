package com.fund.screen.biz.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ViewUtil {

    /**
     * 将某只基金的某个范围内的数据转换为前端展示的j格式
     */
    public JSONObject parseFundDetailInfo(String fcode, String shortName, List<FundDetailInfo> fundDetailInfoList) {
        JSONObject result = new JSONObject();

        JSONObject title = new JSONObject();
        title.put("text", fcode);
        title.put("subtext", shortName);
        result.put("title", title);

        JSONObject tooltip = new JSONObject();
        tooltip.put("trigger", "axis");
        tooltip.put("tooltip", tooltip);
        result.put("tooltip", tooltip);

        JSONObject toolbox = new JSONObject();
        toolbox.put("show", true);
        JSONObject feature = new JSONObject();
        JSONObject dataZoom = new JSONObject();
        dataZoom.put("yAxisIndex", "none");
        JSONObject dataView = new JSONObject();
        dataView.put("readOnly", false);
        JSONObject magicType = new JSONObject();
        String[] var1 = {"line", "bar"};
        magicType.put("type", var1);
        JSONObject restore = new JSONObject();
        JSONObject saveAsImage = new JSONObject();
        feature.put("dataZoom", dataZoom);
        feature.put("dataView", dataView);
        feature.put("magicType", magicType);
        feature.put("restore", restore);
        feature.put("saveAsImage", saveAsImage);
        toolbox.put("feature", feature);
        result.put("toolbox", toolbox);

        JSONObject xAxis = new JSONObject();
        xAxis.put("type", "category");
        xAxis.put("boundaryGap", "false");
        List<String> data= new ArrayList<>();
        fundDetailInfoList.forEach(fundDetailInfo -> data.add(fundDetailInfo.getFsrq()));
        xAxis.put("data", null);
        result.put("xAxis", xAxis);

        JSONObject yAxis = new JSONObject();
        yAxis.put("type", "value");
        JSONObject axisLabel = new JSONObject();
        axisLabel.put("formatter", "{value}");
        result.put("yAxis", yAxis);

        JSONArray series = new JSONArray();
        JSONObject v1 = new JSONObject();
        v1.put("name", "最高气温");
        v1.put("type", "line");
        //todo data
        JSONArray dataV2 = new JSONArray();
        List<String> dataListV1 = new ArrayList<>();
        fundDetailInfoList.forEach(fundDetailInfo -> dataListV1.add(fundDetailInfo.getDwjz()));
        v1.put("data", dataV2);
        JSONObject markPoint = new JSONObject();
        JSONArray dataV1 = new JSONArray();
        JSONObject v2 = new JSONObject();
        v2.put("type", "max");
        v2.put("name", "最大值");
        JSONObject v3 = new JSONObject();
        v3.put("type", "min");
        v3.put("name", "最大值");
        dataV1.add(v2);
        dataV1.add(v3);
        markPoint.put("data", dataV1);
        v1.put("markPoint", markPoint);
        series.add(v1);
        result.put("series", series);

        return result;
    }
}
