package com.ruoyi.examine.service;

import java.util.List;

import com.ruoyi.examine.domain.ExaminePhysical;

/**
 * 数据信息Service接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface IExaminePhysicalService
{
    /**
     * 查询数据信息
     *
     * @param id 数据信息主键
     * @return 数据信息
     */
    public ExaminePhysical selectExaminePhysicalById(Long id);

    /**
     * 查询数据信息列表
     *
     * @param examinePhysical 数据信息
     * @return 数据信息集合
     */
    public List<ExaminePhysical> selectExaminePhysicalList(ExaminePhysical examinePhysical);

    /**
     * 新增数据信息
     *
     * @param examinePhysical 数据信息
     * @return 结果
     */
    public int insertExaminePhysical(ExaminePhysical examinePhysical);

    /**
     * 修改数据信息
     *
     * @param examinePhysical 数据信息
     * @return 结果
     */
    public int updateExaminePhysical(ExaminePhysical examinePhysical);

    /**
     * 批量删除数据信息
     *
     * @param ids 需要删除的数据信息主键集合
     * @return 结果
     */
    public int deleteExaminePhysicalByIds(Long[] ids);

    /**
     * 删除数据信息信息
     *
     * @param id 数据信息主键
     * @return 结果
     */
    public int deleteExaminePhysicalById(Long id);
}
