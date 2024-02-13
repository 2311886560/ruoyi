package com.ruoyi.factory.mapper;

import java.util.List;
import com.ruoyi.factory.domain.GoodsOrder;
import com.ruoyi.factory.domain.GoodsOrderSub;
import com.ruoyi.factory.domain.vo.GoodsOrderFormVo;
import com.ruoyi.factory.domain.vo.GoodsOrderVo;

/**
 * 商品订单Mapper接口
 *
 * @author ruoyi
 * @date 2023-11-11
 */
public interface GoodsOrderMapper
{
    /**
     * 查询商品订单
     *
     * @param id 商品订单主键
     * @return 商品订单
     */
    public GoodsOrderVo selectGoodsOrderById(Long id);

    /**
     * 查询商品订单 列表
     *
     * @param goodsOrder 商品订单
     * @return 商品订单 集合
     */
    public List<GoodsOrderVo> selectGoodsOrderList(GoodsOrderVo goodsOrder);

    /**
     * 新增商品订单
     *
     * @param goodsOrder 商品订单
     * @return 结果
     */
    public int insertGoodsOrder(GoodsOrder goodsOrder);

    /**
     * 修改商品订单
     *
     * @param goodsOrder 商品订单
     * @return 结果
     */
    public int updateGoodsOrder(GoodsOrder goodsOrder);

    /**
     * 删除商品订单
     *
     * @param id 商品订单主键
     * @return 结果
     */
    public int deleteGoodsOrderById(Long id);

    /**
     * 批量删除商品订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsOrderByIds(Long[] ids);

    /**
     * 批量删除商品订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsOrderSubByOrderIds(Long[] ids);

    /**
     * 批量新增商品订单子
     *
     * @param goodsOrderSubList 商品订单子列表
     * @return 结果
     */
    public int batchGoodsOrderSub(List<GoodsOrderSub> goodsOrderSubList);


    /**
     * 通过商品订单主键删除商品订单子信息
     *
     * @param id 商品订单 ID
     * @return 结果
     */
    public int deleteGoodsOrderSubByOrderId(Long id);

    public List<GoodsOrderFormVo> selectGoodsOrderFormList(GoodsOrderFormVo goodsOrder);
}
