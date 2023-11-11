package com.ruoyi.factory.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单主对象 goods_order
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@Data
public class GoodsOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单主表id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderCode;

    /** 订单标题 */
    @Excel(name = "订单标题")
    private String orderTitle;

    /** 卖方企业 */
    @Excel(name = "卖方企业")
    private Long salerEntId;

    /** 买方员工 */
    @Excel(name = "买方员工")
    private Long buyerUserId;

    /** 卖方员工 */
    @Excel(name = "卖方员工")
    private Long salerUserId;

    /** 订单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmTime;

    /** 物流编号 */
    @Excel(name = "物流编号")
    private String logisticsCode;

    /** 0待完成；1已完成，9拒绝 */
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;

    /** 商品订单子信息 */
    private List<GoodsOrderSub> goodsOrderSubList;

    /** 卖方企业名称 */
    private String salerEntName;

    /** 买方用户名称 */
    private String buyerUserName;

    /** 卖方用户名称 */
    private String salerUserName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderCode(String orderCode)
    {
        this.orderCode = orderCode;
    }

    public String getOrderCode()
    {
        return orderCode;
    }
    public void setOrderTitle(String orderTitle)
    {
        this.orderTitle = orderTitle;
    }

    public String getOrderTitle()
    {
        return orderTitle;
    }
    public void setSalerEntId(Long salerEntId)
    {
        this.salerEntId = salerEntId;
    }

    public Long getSalerEntId()
    {
        return salerEntId;
    }
    public void setBuyerUserId(Long buyerUserId)
    {
        this.buyerUserId = buyerUserId;
    }

    public Long getBuyerUserId()
    {
        return buyerUserId;
    }
    public void setSalerUserId(Long salerUserId)
    {
        this.salerUserId = salerUserId;
    }

    public Long getSalerUserId()
    {
        return salerUserId;
    }
    public void setOrderTime(Date orderTime)
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime()
    {
        return orderTime;
    }
    public void setConfirmTime(Date confirmTime)
    {
        this.confirmTime = confirmTime;
    }

    public Date getConfirmTime()
    {
        return confirmTime;
    }
    public void setLogisticsCode(String logisticsCode)
    {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCode()
    {
        return logisticsCode;
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

    public List<GoodsOrderSub> getGoodsOrderSubList()
    {
        return goodsOrderSubList;
    }

    public void setGoodsOrderSubList(List<GoodsOrderSub> goodsOrderSubList)
    {
        this.goodsOrderSubList = goodsOrderSubList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderCode", getOrderCode())
            .append("orderTitle", getOrderTitle())
            .append("salerEntId", getSalerEntId())
            .append("buyerUserId", getBuyerUserId())
            .append("salerUserId", getSalerUserId())
            .append("orderTime", getOrderTime())
            .append("confirmTime", getConfirmTime())
            .append("logisticsCode", getLogisticsCode())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("goodsOrderSubList", getGoodsOrderSubList())
            .toString();
    }
}
