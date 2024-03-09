package com.ruoyi.factory.service;

import java.util.List;

import com.ruoyi.factory.domain.GoodsOrderMessage;

/**
 * 商品订单消息Service接口
 *
 * @author ruoyi
 * @date 2024-03-09
 */
public interface IGoodsOrderMessageService {
    /**
     * 查询商品订单消息
     *
     * @param id 商品订单消息主键
     * @return 商品订单消息
     */
    public GoodsOrderMessage selectGoodsOrderMessageById(Long id);

    /**
     * 查询商品订单消息列表
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 商品订单消息集合
     */
    public List<GoodsOrderMessage> selectGoodsOrderMessageList(GoodsOrderMessage goodsOrderMessage);

    /**
     * 新增商品订单消息
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 结果
     */
    public int insertGoodsOrderMessage(GoodsOrderMessage goodsOrderMessage);

    /**
     * 修改商品订单消息
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 结果
     */
    public int updateGoodsOrderMessage(GoodsOrderMessage goodsOrderMessage);

    /**
     * 批量删除商品订单消息
     *
     * @param ids 需要删除的商品订单消息主键集合
     * @return 结果
     */
    public int deleteGoodsOrderMessageByIds(Long[] ids);

    /**
     * 删除商品订单消息信息
     *
     * @param id 商品订单消息主键
     * @return 结果
     */
    public int deleteGoodsOrderMessageById(Long id);
}
