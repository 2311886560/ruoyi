package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.RetiredMapper;
import com.ruoyi.examine.domain.Retired;
import com.ruoyi.examine.service.IRetiredService;

import javax.annotation.Resource;

/**
 * 干休所信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class RetiredServiceImpl implements IRetiredService
{
    @Resource
    private RetiredMapper retiredMapper;

    /**
     * 查询干休所信息
     *
     * @param id 干休所信息主键
     * @return 干休所信息
     */
    @Override
    public Retired selectRetiredById(Long id)
    {
        return retiredMapper.selectRetiredById(id);
    }

    /**
     * 查询干休所信息列表
     *
     * @param retired 干休所信息
     * @return 干休所信息
     */
    @Override
    public List<Retired> selectRetiredList(Retired retired)
    {
        return retiredMapper.selectRetiredList(retired);
    }

    /**
     * 新增干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    @Override
    public int insertRetired(Retired retired)
    {
        retired.setCreateTime(DateUtils.getNowDate());
        return retiredMapper.insertRetired(retired);
    }

    /**
     * 修改干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    @Override
    public int updateRetired(Retired retired)
    {
        retired.setUpdateTime(DateUtils.getNowDate());
        return retiredMapper.updateRetired(retired);
    }

    /**
     * 批量删除干休所信息
     *
     * @param ids 需要删除的干休所信息主键
     * @return 结果
     */
    @Override
    public int deleteRetiredByIds(Long[] ids)
    {
        return retiredMapper.deleteRetiredByIds(ids);
    }

    /**
     * 删除干休所信息信息
     *
     * @param id 干休所信息主键
     * @return 结果
     */
    @Override
    public int deleteRetiredById(Long id)
    {
        return retiredMapper.deleteRetiredById(id);
    }
}
