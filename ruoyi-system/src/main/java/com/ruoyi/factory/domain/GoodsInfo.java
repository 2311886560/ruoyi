package com.ruoyi.factory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品信息对象 goods_info
 *
 * @author ruoyi
 * @date 2023-10-23
 */
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
    private Long costPrice;

    /** 销售价（默认售价） */
    @Excel(name = "销售价", readConverterExp = "默=认售价")
    private Long salesPric;

    /** 库存量 */
    @Excel(name = "库存量")
    private Long inventory;

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
    public void setEntId(Long entId)
    {
        this.entId = entId;
    }

    public Long getEntId()
    {
        return entId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGoodsType(String goodsType)
    {
        this.goodsType = goodsType;
    }

    public String getGoodsType()
    {
        return goodsType;
    }
    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsBrand()
    {
        return goodsBrand;
    }
    public void setCostPrice(Long costPrice)
    {
        this.costPrice = costPrice;
    }

    public Long getCostPrice()
    {
        return costPrice;
    }
    public void setSalesPric(Long salesPric)
    {
        this.salesPric = salesPric;
    }

    public Long getSalesPric()
    {
        return salesPric;
    }
    public void setInventory(Long inventory)
    {
        this.inventory = inventory;
    }

    public Long getInventory()
    {
        return inventory;
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
            .append("entId", getEntId())
            .append("name", getName())
            .append("goodsType", getGoodsType())
            .append("goodsBrand", getGoodsBrand())
            .append("costPrice", getCostPrice())
            .append("salesPric", getSalesPric())
            .append("inventory", getInventory())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
