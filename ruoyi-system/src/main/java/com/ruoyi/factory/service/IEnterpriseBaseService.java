package com.ruoyi.factory.service;

import java.util.List;
import com.ruoyi.factory.domain.EnterpriseBase;

/**
 * 工厂基本信息Service接口
 *
 * @author ruoyi
 * @date 2023-10-24
 */
public interface IEnterpriseBaseService
{
    /**
     * 查询工厂基本信息
     *
     * @param id 工厂基本信息主键
     * @return 工厂基本信息
     */
    public EnterpriseBase selectEnterpriseBaseById(Long id);

    /**
     * 查询工厂基本信息列表
     *
     * @param enterpriseBase 工厂基本信息
     * @return 工厂基本信息集合
     */
    public List<EnterpriseBase> selectEnterpriseBaseList(EnterpriseBase enterpriseBase);

    /**
     * 新增工厂基本信息
     *
     * @param enterpriseBase 工厂基本信息
     * @return 结果
     */
    public int insertEnterpriseBase(EnterpriseBase enterpriseBase);

    /**
     * 修改工厂基本信息
     *
     * @param enterpriseBase 工厂基本信息
     * @return 结果
     */
    public int updateEnterpriseBase(EnterpriseBase enterpriseBase);

    /**
     * 批量删除工厂基本信息
     *
     * @param ids 需要删除的工厂基本信息主键集合
     * @return 结果
     */
    public int deleteEnterpriseBaseByIds(Long[] ids);

    /**
     * 删除工厂基本信息信息
     *
     * @param id 工厂基本信息主键
     * @return 结果
     */
    public int deleteEnterpriseBaseById(Long id);
}
