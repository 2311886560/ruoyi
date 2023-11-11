package com.ruoyi.factory.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.factory.domain.vo.GoodsOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.factory.domain.GoodsOrderSub;
import com.ruoyi.factory.mapper.GoodsOrderMapper;
import com.ruoyi.factory.domain.GoodsOrder;
import com.ruoyi.factory.service.IGoodsOrderService;

/**
 * 商品订单主Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@Service
public class GoodsOrderServiceImpl implements IGoodsOrderService {
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;

    /**
     * 查询商品订单主
     *
     * @param id 商品订单主主键
     * @return 商品订单主
     */
    @Override
    public GoodsOrder selectGoodsOrderById(Long id) {
        return goodsOrderMapper.selectGoodsOrderById(id);
    }

    /**
     * 查询商品订单主列表
     *
     * @param goodsOrder 商品订单主
     * @return 商品订单主
     */
    @Override
    public List<GoodsOrderVo> selectGoodsOrderList(GoodsOrderVo goodsOrder) {
        return goodsOrderMapper.selectGoodsOrderList(goodsOrder);
    }

    /**
     * 新增商品订单主
     *
     * @param goodsOrder 商品订单主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertGoodsOrder(GoodsOrder goodsOrder) {
        goodsOrder.setCreateTime(DateUtils.getNowDate());
        int rows = goodsOrderMapper.insertGoodsOrder(goodsOrder);
        insertGoodsOrderSub(goodsOrder);
        return rows;
    }

    /**
     * 修改商品订单主
     *
     * @param goodsOrder 商品订单主
     * @return 结果
     */
    @Transactional
    @Override
    public int updateGoodsOrder(GoodsOrder goodsOrder) {
        goodsOrder.setUpdateTime(DateUtils.getNowDate());
        goodsOrderMapper.deleteGoodsOrderSubByOrderId(goodsOrder.getId());
        insertGoodsOrderSub(goodsOrder);
        return goodsOrderMapper.updateGoodsOrder(goodsOrder);
    }

    /**
     * 批量删除商品订单主
     *
     * @param ids 需要删除的商品订单主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsOrderByIds(Long[] ids) {
        goodsOrderMapper.deleteGoodsOrderSubByOrderIds(ids);
        return goodsOrderMapper.deleteGoodsOrderByIds(ids);
    }

    /**
     * 删除商品订单主信息
     *
     * @param id 商品订单主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsOrderById(Long id) {
        goodsOrderMapper.deleteGoodsOrderSubByOrderId(id);
        return goodsOrderMapper.deleteGoodsOrderById(id);
    }

    /**
     * 新增商品订单子信息
     *
     * @param goodsOrder 商品订单主对象
     */
    public void insertGoodsOrderSub(GoodsOrder goodsOrder) {
        List<GoodsOrderSub> goodsOrderSubList = goodsOrder.getGoodsOrderSubList();
        Long id = goodsOrder.getId();
        if (StringUtils.isNotNull(goodsOrderSubList)) {
            List<GoodsOrderSub> list = new ArrayList<GoodsOrderSub>();
            for (GoodsOrderSub goodsOrderSub : goodsOrderSubList) {
                goodsOrderSub.setOrderId(id);
                list.add(goodsOrderSub);
            }
            if (list.size() > 0) {
                goodsOrderMapper.batchGoodsOrderSub(list);
            }
        }
    }
}
