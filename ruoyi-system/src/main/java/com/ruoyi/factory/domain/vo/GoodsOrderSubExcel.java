package com.ruoyi.factory.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsOrderSubExcel {

    /** 买方员工 */
    @Excel(name = "客户名称")
    private String buyerUserName;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 商品总数量 */
    @Excel(name = "购买数量")
    private BigDecimal goodsAmountTotal;

    /** 商品总成本价 */
    @Excel(name = "成本")
    private BigDecimal goodsCostPriceTotal;

    /** 商品总销售价 */
    @Excel(name = "销售价")
    private BigDecimal goodsSalesPriceTotal;

    /** 商品总利润 */
    @Excel(name = "利润")
    private BigDecimal goodsProfitPriceTotal;


}
