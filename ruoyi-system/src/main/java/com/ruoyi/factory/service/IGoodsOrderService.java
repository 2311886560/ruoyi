package com.ruoyi.factory.service;

import java.util.List;

import com.ruoyi.factory.domain.GoodsOrder;
import com.ruoyi.factory.domain.vo.GoodsOrderVo;

/**
 * 商品订单主Service接口
 *
 * @author ruoyi
 * @date 2023-11-11
 */
public interface IGoodsOrderService {
    /**
     * 查询商品订单主
     *
     * @param id 商品订单主主键
     * @return 商品订单主
     */
    public GoodsOrderVo selectGoodsOrderById(Long id);

    /**
     * 查询商品订单主列表
     *
     * @param goodsOrder 商品订单主
     * @return 商品订单主集合
     */
    public List<GoodsOrderVo> selectGoodsOrderList(GoodsOrderVo goodsOrder);

    /**
     * 新增商品订单主
     *
     * @param goodsOrderVo 商品订单主
     * @return 结果
     */
    public int insertGoodsOrder(GoodsOrderVo goodsOrderVo);

    /**
     * 修改商品订单主
     *
     * @param goodsOrderVo 商品订单主
     * @return 结果
     */
    public int updateGoodsOrder(GoodsOrderVo goodsOrderVo);

    /**
     * 批量删除商品订单主
     *
     * @param ids 需要删除的商品订单主主键集合
     * @return 结果
     */
    public int deleteGoodsOrderByIds(Long[] ids);

    /**
     * 删除商品订单主信息
     *
     * @param id 商品订单主主键
     * @return 结果
     */
    public int deleteGoodsOrderById(Long id);
}
