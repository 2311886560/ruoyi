package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.HospitalMapper;
import com.ruoyi.examine.domain.Hospital;
import com.ruoyi.examine.service.IHospitalService;

import javax.annotation.Resource;

/**
 * 医院信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class HospitalServiceImpl implements IHospitalService
{
    @Resource
    private HospitalMapper hospitalMapper;

    /**
     * 查询医院信息
     *
     * @param id 医院信息主键
     * @return 医院信息
     */
    @Override
    public Hospital selectHospitalById(Long id)
    {
        return hospitalMapper.selectHospitalById(id);
    }

    /**
     * 查询医院信息列表
     *
     * @param hospital 医院信息
     * @return 医院信息
     */
    @Override
    public List<Hospital> selectHospitalList(Hospital hospital)
    {
        return hospitalMapper.selectHospitalList(hospital);
    }

    /**
     * 新增医院信息
     *
     * @param hospital 医院信息
     * @return 结果
     */
    @Override
    public int insertHospital(Hospital hospital)
    {
        hospital.setCreateTime(DateUtils.getNowDate());
        return hospitalMapper.insertHospital(hospital);
    }

    /**
     * 修改医院信息
     *
     * @param hospital 医院信息
     * @return 结果
     */
    @Override
    public int updateHospital(Hospital hospital)
    {
        hospital.setUpdateTime(DateUtils.getNowDate());
        return hospitalMapper.updateHospital(hospital);
    }

    /**
     * 批量删除医院信息
     *
     * @param ids 需要删除的医院信息主键
     * @return 结果
     */
    @Override
    public int deleteHospitalByIds(Long[] ids)
    {
        return hospitalMapper.deleteHospitalByIds(ids);
    }

    /**
     * 删除医院信息信息
     *
     * @param id 医院信息主键
     * @return 结果
     */
    @Override
    public int deleteHospitalById(Long id)
    {
        return hospitalMapper.deleteHospitalById(id);
    }
}
