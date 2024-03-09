package com.ruoyi.factory.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单消息对象 goods_order_message
 *
 * @author ruoyi
 * @date 2024-03-09
 */
@Data
public class GoodsOrderMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单子表id */
    private Long id;

    /** 订单主表id */
    @Excel(name = "订单主表id")
    private Long orderId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String messageContent;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
