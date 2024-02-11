package com.ruoyi.factory.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.factory.domain.GoodsOrder;
import com.ruoyi.factory.domain.GoodsOrderSub;
import lombok.Data;

import java.util.List;

@Data
public class GoodsOrderVo extends GoodsOrder {

    private String entName;

    /** 商品订单子信息 */
    private List<GoodsOrderSub> goodsOrderSubList;

    /** 卖方企业名称 */
    private String salerEntName;

    /** 买方用户名称 */
    @Excel(name = "购买用户", sort = 3)
    private String buyerUserName;

    /** 卖方用户名称 */
    @Excel(name = "员工", sort = 4)
    private String salerUserName;
}
