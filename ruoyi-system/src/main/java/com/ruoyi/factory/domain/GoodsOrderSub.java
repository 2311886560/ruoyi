package com.ruoyi.factory.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 商品订单子对象 goods_order_sub
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@Data
public class GoodsOrderSub extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单子表id */
    private Long id;

    /** 订单主表id */
    @Excel(name = "订单主表id")
    private Long orderId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsId;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal orderAmount;

    /** 销售价 */
    @Excel(name = "销售价")
    private BigDecimal salesPrice;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
