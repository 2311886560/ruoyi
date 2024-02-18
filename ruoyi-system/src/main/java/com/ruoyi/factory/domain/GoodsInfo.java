package com.ruoyi.factory.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 商品信息对象 goods_info
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Data
public class GoodsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 工厂工厂id */
    @Excel(name = "工厂工厂id")
    private Long entId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 类型：0-五金，1-化工，2-食品，3-水产 */
    @Excel(name = "类型：0-五金，1-化工，2-食品，3-水产")
    private String goodsType;

    /** 品牌 */
    @Excel(name = "品牌")
    private String goodsBrand;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal costPrice;

    /** 销售价（默认售价） */
    @Excel(name = "销售价", readConverterExp = "默=认售价")
    private BigDecimal salesPrice;

    /** 库存量 */
    @Excel(name = "库存量")
    private BigDecimal inventory;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;

    /** 商品图片 */
//    @Excel(name = "商品图片")
    private String goodsPicture;

}
