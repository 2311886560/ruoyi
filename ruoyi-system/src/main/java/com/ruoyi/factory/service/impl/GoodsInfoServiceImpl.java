package com.ruoyi.factory.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.factory.domain.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.factory.mapper.GoodsInfoMapper;
import com.ruoyi.factory.domain.GoodsInfo;
import com.ruoyi.factory.service.IGoodsInfoService;

import javax.annotation.Resource;

/**
 * 商品信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    @Override
    public GoodsInfo selectGoodsInfoById(Long id) {
        return goodsInfoMapper.selectGoodsInfoById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param goodsInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<GoodsInfoVo> selectGoodsInfoList(GoodsInfo goodsInfo) {
        return goodsInfoMapper.selectGoodsInfoList(goodsInfo);
    }

    /**
     * 新增商品信息
     *
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Override
    public int insertGoodsInfo(GoodsInfo goodsInfo) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        if (StringUtils.isNull(user.getEntId())) {
            throw new ServiceException("当前用户未分配企业！");
        }
        goodsInfo.setEntId(user.getEntId());
        // 设置默认值
        if (StringUtils.isEmpty(goodsInfo.getStatus())) {
            goodsInfo.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(goodsInfo.getDelFlag())) {
            goodsInfo.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        goodsInfo.setCreateBy(user.getUserName());
        goodsInfo.setCreateTime(DateUtils.getNowDate());
        return goodsInfoMapper.insertGoodsInfo(goodsInfo);
    }

    /**
     * 修改商品信息
     *
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo) {
        // 获取当前登录用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        goodsInfo.setCreateBy(user.getUserName());
        goodsInfo.setUpdateTime(DateUtils.getNowDate());
        return goodsInfoMapper.updateGoodsInfo(goodsInfo);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsInfoByIds(Long[] ids) {
        return goodsInfoMapper.deleteGoodsInfoByIds(ids);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsInfoById(Long id) {
        return goodsInfoMapper.deleteGoodsInfoById(id);
    }
}
