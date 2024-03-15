package com.ruoyi.factory.domain.vo;

import com.ruoyi.factory.domain.GoodsInfo;

import lombok.Data;

@Data
public class GoodsInfoVo extends GoodsInfo {

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 显示警告数据
     */
    private String showWarn;


}
