package com.ruoyi.factory.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.enums.UserType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
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

import javax.annotation.Resource;

/**
 * 商品订单主Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@Service
public class GoodsOrderServiceImpl implements IGoodsOrderService {
    @Resource
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
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        if (UserType.FACTORY_USER.getCode().equals(user.getUserType())) {
            // 用户为工厂客户，只允许查询自己购买的订单
            goodsOrder.setBuyerUserId(user.getUserId());
        }
        return goodsOrderMapper.selectGoodsOrderList(goodsOrder);
    }

    /**
     * 新增商品订单主
     *
     * @param goodsOrderVo 商品订单主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertGoodsOrder(GoodsOrderVo goodsOrderVo) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Date nowDate = DateUtils.getNowDate();
        // 卖方用户采用当前登录者的用户
        goodsOrderVo.setSalerUserId(user.getUserId());
        if (UserType.FACTORY_USER.getCode().equals(user.getUserType())) {
            // 用户为工厂客户，自己为买方用户
            goodsOrderVo.setBuyerUserId(user.getUserId());
        }
        // 设置默认值
        if (StringUtils.isEmpty(goodsOrderVo.getStatus())) {
            goodsOrderVo.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(goodsOrderVo.getDelFlag())) {
            goodsOrderVo.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        // 取当前时间作为订单时间
        goodsOrderVo.setOrderTime(nowDate);

        goodsOrderVo.setCreateBy(user.getUserName());
        goodsOrderVo.setCreateTime(nowDate);
        goodsOrderVo.setUpdateBy(user.getUserName());
        goodsOrderVo.setUpdateTime(nowDate);
        int rows = goodsOrderMapper.insertGoodsOrder(goodsOrderVo);
        insertGoodsOrderSub(goodsOrderVo);
        return rows;
    }

    /**
     * 修改商品订单主
     *
     * @param goodsOrderVo 商品订单主
     * @return 结果
     */
    @Transactional
    @Override
    public int updateGoodsOrder(GoodsOrderVo goodsOrderVo) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Date nowDate = DateUtils.getNowDate();

        goodsOrderVo.setUpdateBy(user.getUserName());
        goodsOrderVo.setUpdateTime(nowDate);
        goodsOrderMapper.deleteGoodsOrderSubByOrderId(goodsOrderVo.getId());
        insertGoodsOrderSub(goodsOrderVo);
        return goodsOrderMapper.updateGoodsOrder(goodsOrderVo);
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
     * @param goodsOrderVo 商品订单主对象
     */
    public void insertGoodsOrderSub(GoodsOrderVo goodsOrderVo) {
        List<GoodsOrderSub> goodsOrderSubList = goodsOrderVo.getGoodsOrderSubList();
        Long id = goodsOrderVo.getId();
        if (StringUtils.isNotNull(goodsOrderSubList)) {
            List<GoodsOrderSub> list = new ArrayList<GoodsOrderSub>();
            for (GoodsOrderSub goodsOrderSub : goodsOrderSubList) {
                goodsOrderSub.setOrderId(id);
                // 设置默认值
                if (StringUtils.isEmpty(goodsOrderSub.getStatus())) {
                    goodsOrderSub.setStatus(CommonStatus.NORMAL.getCode());
                }
                if (StringUtils.isEmpty(goodsOrderSub.getDelFlag())) {
                    goodsOrderSub.setDelFlag(CommonDelFlag.UNDELETED.getCode());
                }
                list.add(goodsOrderSub);
            }
            if (list.size() > 0) {
                goodsOrderMapper.batchGoodsOrderSub(list);
            }
        }
    }
}
