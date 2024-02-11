package com.ruoyi.factory.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.factory.domain.GoodsOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsOrderFormVo {

    /** 商品id */
    private Long goodsId;

    /** 卖方企业 */
    private Long salerEntId;

    /** 买方员工 */
    private Long buyerUserId;

    /** 卖方员工 */
    private Long salerUserId;

    /** 开始时间 */
    private String beginTime;

    /** 结束时间 */
    private String endTime;

    /** 订单时间（年月维度） */
    @Excel(name = "订单时间")
    private String orderTime;

    @Excel(name = "成本")
    private BigDecimal orderCodeTotal;

    @Excel(name = "利润")
    private BigDecimal profitPriceTotal;

    @Excel(name = "销售价")
    private BigDecimal salesPriceTotal;

    /** 订单数量 */
    private BigDecimal orderNumberTotal;


}
