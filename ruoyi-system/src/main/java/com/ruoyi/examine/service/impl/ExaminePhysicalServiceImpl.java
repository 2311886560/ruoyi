package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExaminePhysicalMapper;
import com.ruoyi.examine.domain.ExaminePhysical;
import com.ruoyi.examine.service.IExaminePhysicalService;

import javax.annotation.Resource;

/**
 * 数据信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class ExaminePhysicalServiceImpl implements IExaminePhysicalService
{
    @Resource
    private ExaminePhysicalMapper examinePhysicalMapper;

    /**
     * 查询数据信息
     *
     * @param id 数据信息主键
     * @return 数据信息
     */
    @Override
    public ExaminePhysical selectExaminePhysicalById(Long id)
    {
        return examinePhysicalMapper.selectExaminePhysicalById(id);
    }

    /**
     * 查询数据信息列表
     *
     * @param examinePhysical 数据信息
     * @return 数据信息
     */
    @Override
    public List<ExaminePhysical> selectExaminePhysicalList(ExaminePhysical examinePhysical)
    {
        return examinePhysicalMapper.selectExaminePhysicalList(examinePhysical);
    }

    /**
     * 新增数据信息
     *
     * @param examinePhysical 数据信息
     * @return 结果
     */
    @Override
    public int insertExaminePhysical(ExaminePhysical examinePhysical)
    {
        examinePhysical.setCreateTime(DateUtils.getNowDate());
        return examinePhysicalMapper.insertExaminePhysical(examinePhysical);
    }

    /**
     * 修改数据信息
     *
     * @param examinePhysical 数据信息
     * @return 结果
     */
    @Override
    public int updateExaminePhysical(ExaminePhysical examinePhysical)
    {
        examinePhysical.setUpdateTime(DateUtils.getNowDate());
        return examinePhysicalMapper.updateExaminePhysical(examinePhysical);
    }

    /**
     * 批量删除数据信息
     *
     * @param ids 需要删除的数据信息主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalByIds(Long[] ids)
    {
        return examinePhysicalMapper.deleteExaminePhysicalByIds(ids);
    }

    /**
     * 删除数据信息信息
     *
     * @param id 数据信息主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalById(Long id)
    {
        return examinePhysicalMapper.deleteExaminePhysicalById(id);
    }
}
