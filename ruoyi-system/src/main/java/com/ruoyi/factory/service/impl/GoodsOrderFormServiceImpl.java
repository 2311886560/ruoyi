package com.ruoyi.factory.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.UserType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.factory.domain.EnterpriseBase;
import com.ruoyi.factory.domain.vo.GoodsOrderFormVo;
import com.ruoyi.factory.mapper.EnterpriseBaseMapper;
import com.ruoyi.factory.mapper.GoodsOrderMapper;
import com.ruoyi.factory.service.IGoodsOrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsOrderFormServiceImpl implements IGoodsOrderFormService {
    @Resource
    private GoodsOrderMapper goodsOrderMapper;
    @Resource
    private EnterpriseBaseMapper enterpriseBaseMapper;

    @Override
    public List<GoodsOrderFormVo> selectGoodsOrderFormList(GoodsOrderFormVo goodsOrder) {

        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        if (UserType.FACTORY_USER.getCode().equals(user.getUserType())) {
            // 用户为工厂客户，只允许查询自己购买的订单
            goodsOrder.setBuyerUserId(user.getUserId());
        }

        List<GoodsOrderFormVo> goodsOrderFormVoList = goodsOrderMapper.selectGoodsOrderFormList(goodsOrder);
        return goodsOrderFormVoList;
    }

    @Override
    public JSONObject statisticsOrder(GoodsOrderFormVo vo) {
        JSONObject jsonObject = new JSONObject();
        List<String> times = DateUtils.getYearMonthArray(DateUtils.parseDate(vo.getBeginTime()), DateUtils.parseDate(vo.getEndTime()));
        JSONObject patrolChartDataByNumber = new JSONObject();
        patrolChartDataByNumber.put("xAxisName", "年月");
        patrolChartDataByNumber.put("xAxis", times);
        JSONObject patrolChartDataByOrderCode = new JSONObject();
        patrolChartDataByOrderCode.put("xAxisName", "年月");
        patrolChartDataByOrderCode.put("xAxis", times);
        JSONObject patrolChartDataBySalesPrice = new JSONObject();
        patrolChartDataBySalesPrice.put("xAxisName", "年月");
        patrolChartDataBySalesPrice.put("xAxis", times);

        List<JSONObject> dataList = new ArrayList<>();
        // 先查询所有的企业列表(防止后面系统优化为允许多企业)
        EnterpriseBase enterpriseBase = new EnterpriseBase();
        List<EnterpriseBase> enterpriseBaseList = enterpriseBaseMapper.selectEnterpriseBaseList(enterpriseBase);
        if (StringUtils.isNotEmpty(enterpriseBaseList)) {
            enterpriseBaseList.forEach(item -> {
                GoodsOrderFormVo orderFormVo = new GoodsOrderFormVo();
                orderFormVo.setSalerEntId(item.getId());
                orderFormVo.setGoodsId(vo.getGoodsId());
                orderFormVo.setBeginTime(vo.getBeginTime());
                orderFormVo.setEndTime(vo.getEndTime());
                List<GoodsOrderFormVo> goodsOrderFormVoList = goodsOrderMapper.selectGoodsOrderFormList(orderFormVo);
                JSONObject dataJson = new JSONObject();
                dataJson.put("name", item.getEntName());
                dataJson.put("type", "bar");
                dataJson.put("data", goodsOrderFormVoList);
                dataList.add(dataJson);
            });
        }
        if (StringUtils.isNotEmpty(dataList)) {
            List<JSONObject> dataByNumberList = new ArrayList<>();
            List<JSONObject> dataByOrderCodeList = new ArrayList<>();
            List<JSONObject> dataBySalesPriceList = new ArrayList<>();
            dataList.forEach(data->{
                List<BigDecimal> itemDataByNumberList = new ArrayList<>();
                List<BigDecimal> itemDataByOrderCodeList = new ArrayList<>();
                List<BigDecimal> itemDataBySalesPriceList = new ArrayList<>();
                if (StringUtils.isNotEmpty(times)){
                    times.forEach(time->{
                        List<GoodsOrderFormVo> goodsOrderFormVoList = (List<GoodsOrderFormVo>) data.get("data");
                        Optional<GoodsOrderFormVo> result = goodsOrderFormVoList.stream()
                                .filter(item -> StringUtils.equals(item.getOrderTime(), time))
                                .findFirst();
                        if (result.isPresent()) {
                            itemDataByNumberList.add(result.get().getOrderNumberTotal());
                            itemDataByOrderCodeList.add(result.get().getOrderCodeTotal());
                            itemDataBySalesPriceList.add(result.get().getSalesPriceTotal());
                        } else {
                            itemDataByNumberList.add(BigDecimal.ZERO);
                            itemDataByOrderCodeList.add(BigDecimal.ZERO);
                            itemDataBySalesPriceList.add(BigDecimal.ZERO);
                        }
                    });
                }
                JSONObject dataJsonByNumber = new JSONObject();
                dataJsonByNumber.put("name", data.get("name"));
                dataJsonByNumber.put("type", data.get("type"));
                dataJsonByNumber.put("data", itemDataByNumberList);
                dataByNumberList.add(dataJsonByNumber);
                JSONObject dataJsonByOrderCode = new JSONObject();
                dataJsonByOrderCode.put("name", data.get("name"));
                dataJsonByOrderCode.put("type", data.get("type"));
                dataJsonByOrderCode.put("data", itemDataByOrderCodeList);
                dataByOrderCodeList.add(dataJsonByOrderCode);
                JSONObject dataJsonBySalesPrice = new JSONObject();
                dataJsonBySalesPrice.put("name", data.get("name"));
                dataJsonBySalesPrice.put("type", data.get("type"));
                dataJsonBySalesPrice.put("data", itemDataBySalesPriceList);
                dataBySalesPriceList.add(dataJsonBySalesPrice);
            });
            patrolChartDataByNumber.put("data", dataByNumberList);
            patrolChartDataByOrderCode.put("data", dataByOrderCodeList);
            patrolChartDataBySalesPrice.put("data", dataBySalesPriceList);
        }
        jsonObject.put("patrolChartDataByNumber", patrolChartDataByNumber);
        jsonObject.put("patrolChartDataByOrderCode", patrolChartDataByOrderCode);
        jsonObject.put("patrolChartDataBySalesPrice", patrolChartDataBySalesPrice);
        return jsonObject;
    }
}
