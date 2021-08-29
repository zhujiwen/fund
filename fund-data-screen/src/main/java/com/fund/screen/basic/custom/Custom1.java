package com.fund.screen.basic.custom;

import com.fund.capture.basic.table.bean.FundBaseInfo;
import com.fund.capture.basic.table.bean.FundDetailInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Custom1 {
    /**
     * 查询某个偏移量范围内的基金列表
     */
    List<FundBaseInfo> queryFundBaseInfoList(@Param("start") int start, @Param("size") int size);

    /**
     *
     */
    List<FundDetailInfo> queryFundDetailInfoList(@Param("start") int start, @Param("size") int size);

    /**
     * 查询从起始日期到目前的某只基金具体信息列表
     */
    List<FundDetailInfo> queryFundDetailInfoListByStartDate(int fcode, String startDate);

}
