package com.fund.basic.custom;

import com.fund.basic.table.bean.FundBaseInfo;
import com.fund.basic.table.bean.FundDetailInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Custom1 {
    /**
     * 查询某个偏移量范围内的基金列表
     */
    List<FundBaseInfo> queryFundBaseInfoList(@Param("start") int start, @Param("size") int size);

    /**
     * 获取
     */
    List<FundDetailInfo> queryFundDetailInfoList(@Param("start") int start, @Param("size") int size);

    /**
     * 查询从起始日期到目前的某只基金具体信息列表
     */
    List<FundDetailInfo> queryFundDetailInfoListByStartDate(@Param("fcode") String fcode, @Param("startDate") String startDate);

}
