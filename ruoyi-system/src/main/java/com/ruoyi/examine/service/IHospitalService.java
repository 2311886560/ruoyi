package com.ruoyi.examine.service;

import java.util.List;

import com.ruoyi.examine.domain.Hospital;

/**
 * 医院信息Service接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface IHospitalService
{
    /**
     * 查询医院信息
     *
     * @param id 医院信息主键
     * @return 医院信息
     */
    public Hospital selectHospitalById(Long id);

    /**
     * 查询医院信息列表
     *
     * @param hospital 医院信息
     * @return 医院信息集合
     */
    public List<Hospital> selectHospitalList(Hospital hospital);

    /**
     * 新增医院信息
     *
     * @param hospital 医院信息
     * @return 结果
     */
    public int insertHospital(Hospital hospital);

    /**
     * 修改医院信息
     *
     * @param hospital 医院信息
     * @return 结果
     */
    public int updateHospital(Hospital hospital);

    /**
     * 批量删除医院信息
     *
     * @param ids 需要删除的医院信息主键集合
     * @return 结果
     */
    public int deleteHospitalByIds(Long[] ids);

    /**
     * 删除医院信息信息
     *
     * @param id 医院信息主键
     * @return 结果
     */
    public int deleteHospitalById(Long id);
}
