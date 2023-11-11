package com.ruoyi.factory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单子对象 goods_order_sub
 *
 * @author ruoyi
 * @date 2023-11-11
 */
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
    private Long orderAmount;

    /** 销售价 */
    @Excel(name = "销售价")
    private Long salesPrice;

    /** 总价 */
    @Excel(name = "总价")
    private Long totalPrice;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setOrderAmount(Long orderAmount)
    {
        this.orderAmount = orderAmount;
    }

    public Long getOrderAmount()
    {
        return orderAmount;
    }
    public void setSalesPrice(Long salesPrice)
    {
        this.salesPrice = salesPrice;
    }

    public Long getSalesPrice()
    {
        return salesPrice;
    }
    public void setTotalPrice(Long totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Long getTotalPrice()
    {
        return totalPrice;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("goodsId", getGoodsId())
            .append("orderAmount", getOrderAmount())
            .append("salesPrice", getSalesPrice())
            .append("totalPrice", getTotalPrice())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
