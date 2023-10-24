package com.ruoyi.factory.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.factory.mapper.EnterpriseBaseMapper;
import com.ruoyi.factory.domain.EnterpriseBase;
import com.ruoyi.factory.service.IEnterpriseBaseService;

/**
 * 工厂基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-24
 */
@Service
public class EnterpriseBaseServiceImpl implements IEnterpriseBaseService
{
    @Autowired
    private EnterpriseBaseMapper enterpriseBaseMapper;

    /**
     * 查询工厂基本信息
     *
     * @param id 工厂基本信息主键
     * @return 工厂基本信息
     */
    @Override
    public EnterpriseBase selectEnterpriseBaseById(Long id)
    {
        return enterpriseBaseMapper.selectEnterpriseBaseById(id);
    }

    /**
     * 查询工厂基本信息列表
     *
     * @param enterpriseBase 工厂基本信息
     * @return 工厂基本信息
     */
    @Override
    public List<EnterpriseBase> selectEnterpriseBaseList(EnterpriseBase enterpriseBase)
    {
        return enterpriseBaseMapper.selectEnterpriseBaseList(enterpriseBase);
    }

    /**
     * 新增工厂基本信息
     *
     * @param enterpriseBase 工厂基本信息
     * @return 结果
     */
    @Override
    public int insertEnterpriseBase(EnterpriseBase enterpriseBase)
    {
        enterpriseBase.setCreateTime(DateUtils.getNowDate());
        return enterpriseBaseMapper.insertEnterpriseBase(enterpriseBase);
    }

    /**
     * 修改工厂基本信息
     *
     * @param enterpriseBase 工厂基本信息
     * @return 结果
     */
    @Override
    public int updateEnterpriseBase(EnterpriseBase enterpriseBase)
    {
        enterpriseBase.setUpdateTime(DateUtils.getNowDate());
        return enterpriseBaseMapper.updateEnterpriseBase(enterpriseBase);
    }

    /**
     * 批量删除工厂基本信息
     *
     * @param ids 需要删除的工厂基本信息主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseBaseByIds(Long[] ids)
    {
        return enterpriseBaseMapper.deleteEnterpriseBaseByIds(ids);
    }

    /**
     * 删除工厂基本信息信息
     *
     * @param id 工厂基本信息主键
     * @return 结果
     */
    @Override
    public int deleteEnterpriseBaseById(Long id)
    {
        return enterpriseBaseMapper.deleteEnterpriseBaseById(id);
    }
}
