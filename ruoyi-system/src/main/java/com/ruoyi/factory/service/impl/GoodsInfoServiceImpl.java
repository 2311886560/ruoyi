package com.ruoyi.factory.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.factory.mapper.GoodsInfoMapper;
import com.ruoyi.factory.domain.GoodsInfo;
import com.ruoyi.factory.service.IGoodsInfoService;

/**
 * 商品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService 
{
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 查询商品信息
     * 
     * @param id 商品信息主键
     * @return 商品信息
     */
    @Override
    public GoodsInfo selectGoodsInfoById(Long id)
    {
        return goodsInfoMapper.selectGoodsInfoById(id);
    }

    /**
     * 查询商品信息列表
     * 
     * @param goodsInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo)
    {
        return goodsInfoMapper.selectGoodsInfoList(goodsInfo);
    }

    /**
     * 新增商品信息
     * 
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Override
    public int insertGoodsInfo(GoodsInfo goodsInfo)
    {
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
    public int updateGoodsInfo(GoodsInfo goodsInfo)
    {
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
    public int deleteGoodsInfoByIds(Long[] ids)
    {
        return goodsInfoMapper.deleteGoodsInfoByIds(ids);
    }

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsInfoById(Long id)
    {
        return goodsInfoMapper.deleteGoodsInfoById(id);
    }
}
