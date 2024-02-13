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
    @Excel(name = "订单编号", sort = 1)
    private String orderCode;

    /** 订单标题 */
    @Excel(name = "订单标题", sort = 2)
    private String orderTitle;

    /** 卖方企业 */
//    @Excel(name = "卖方企业")
    private Long salerEntId;

    /** 购买用户 */
//    @Excel(name = "购买用户")
    private Long buyerUserId;

    /** 卖方员工 */
//    @Excel(name = "员工")
    private Long salerUserId;

    /** 订单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单时间", width = 30, dateFormat = "yyyy-MM-dd", sort = 5)
    private Date orderTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd", sort = 6)
    private Date confirmTime;

    /** 物流编号 */
    @Excel(name = "物流编号", sort = 7)
    private String logisticsCode;

    /** 0待完成；1已完成,9拒绝 */
    @Excel(name = "订单状态", readConverterExp = "0=待完成,1=已完成,9=拒绝", sort = 8)
    private String status;

    /** 删除状态：0=未删除,1=已删除 */
    private String delFlag;

    /** 生产状态：0=未开始,1=加工,2=组装,3=质检,4=包装,5=生产完成 */
    @Excel(name = "生产状态", readConverterExp = "0=未开始,1=加工,2=组装,3=质检,4=包装,5=生产完成", sort = 9)
    private String produceStatus;

    /** 交货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "交货时间", width = 30, dateFormat = "yyyy-MM-dd", sort = 6)
    private Date deliveryTime;

    /** 交货地址 */
    private String deliveryAddress;

    /** 联系方式 */
    @Excel(name = "订单标题", sort = 10)
    private String contactPhone;
}
