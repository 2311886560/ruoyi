package com.ruoyi.factory.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.factory.domain.vo.GoodsOrderFormVo;

import java.util.List;

public interface IGoodsOrderFormService {

    public List<GoodsOrderFormVo> selectGoodsOrderFormList(GoodsOrderFormVo goodsOrderFormVo);
    public List<GoodsOrderFormVo> selectGoodsOrderSubFormList(GoodsOrderFormVo goodsOrderFormVo);

    public JSONObject statisticsOrder(GoodsOrderFormVo goodsOrderFormVo);
}
