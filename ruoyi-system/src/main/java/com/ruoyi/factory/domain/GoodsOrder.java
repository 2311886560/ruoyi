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
}
