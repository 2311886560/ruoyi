package com.ruoyi.factory.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.factory.mapper.GoodsOrderMessageMapper;
import com.ruoyi.factory.domain.GoodsOrderMessage;
import com.ruoyi.factory.service.IGoodsOrderMessageService;

/**
 * 商品订单消息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-09
 */
@Service
public class GoodsOrderMessageServiceImpl implements IGoodsOrderMessageService {
    @Autowired
    private GoodsOrderMessageMapper goodsOrderMessageMapper;

    /**
     * 查询商品订单消息
     *
     * @param id 商品订单消息主键
     * @return 商品订单消息
     */
    @Override
    public GoodsOrderMessage selectGoodsOrderMessageById(Long id) {
        return goodsOrderMessageMapper.selectGoodsOrderMessageById(id);
    }

    /**
     * 查询商品订单消息列表
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 商品订单消息
     */
    @Override
    public List<GoodsOrderMessage> selectGoodsOrderMessageList(GoodsOrderMessage goodsOrderMessage) {
        return goodsOrderMessageMapper.selectGoodsOrderMessageList(goodsOrderMessage);
    }

    /**
     * 新增商品订单消息
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 结果
     */
    @Override
    public int insertGoodsOrderMessage(GoodsOrderMessage goodsOrderMessage) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 设置默认值
        if (StringUtils.isEmpty(goodsOrderMessage.getStatus())) {
            goodsOrderMessage.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(goodsOrderMessage.getDelFlag())) {
            goodsOrderMessage.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        goodsOrderMessage.setUserId(user.getUserId());
        goodsOrderMessage.setUserName(user.getUserName());

        goodsOrderMessage.setCreateBy(user.getUserName());
        goodsOrderMessage.setCreateTime(DateUtils.getNowDate());
        goodsOrderMessage.setUpdateBy(user.getUserName());
        goodsOrderMessage.setUpdateTime(DateUtils.getNowDate());
        return goodsOrderMessageMapper.insertGoodsOrderMessage(goodsOrderMessage);
    }

    /**
     * 修改商品订单消息
     *
     * @param goodsOrderMessage 商品订单消息
     * @return 结果
     */
    @Override
    public int updateGoodsOrderMessage(GoodsOrderMessage goodsOrderMessage) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();

        goodsOrderMessage.setUpdateBy(user.getUserName());
        goodsOrderMessage.setUpdateTime(DateUtils.getNowDate());
        return goodsOrderMessageMapper.updateGoodsOrderMessage(goodsOrderMessage);
    }

    /**
     * 批量删除商品订单消息
     *
     * @param ids 需要删除的商品订单消息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsOrderMessageByIds(Long[] ids) {
        return goodsOrderMessageMapper.deleteGoodsOrderMessageByIds(ids);
    }

    /**
     * 删除商品订单消息信息
     *
     * @param id 商品订单消息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsOrderMessageById(Long id) {
        return goodsOrderMessageMapper.deleteGoodsOrderMessageById(id);
    }
}
