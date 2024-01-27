package com.ruoyi.examine.service;

import java.util.List;
import com.ruoyi.examine.domain.ExaminePhysicalAuthLog;

/**
 * 数据审核记录Service接口
 * 
 * @author ruoyi
 * @date 2024-01-27
 */
public interface IExaminePhysicalAuthLogService 
{
    /**
     * 查询数据审核记录
     * 
     * @param id 数据审核记录主键
     * @return 数据审核记录
     */
    public ExaminePhysicalAuthLog selectExaminePhysicalAuthLogById(Long id);

    /**
     * 查询数据审核记录列表
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 数据审核记录集合
     */
    public List<ExaminePhysicalAuthLog> selectExaminePhysicalAuthLogList(ExaminePhysicalAuthLog examinePhysicalAuthLog);

    /**
     * 新增数据审核记录
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    public int insertExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog);

    /**
     * 修改数据审核记录
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    public int updateExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog);

    /**
     * 批量删除数据审核记录
     * 
     * @param ids 需要删除的数据审核记录主键集合
     * @return 结果
     */
    public int deleteExaminePhysicalAuthLogByIds(Long[] ids);

    /**
     * 删除数据审核记录信息
     * 
     * @param id 数据审核记录主键
     * @return 结果
     */
    public int deleteExaminePhysicalAuthLogById(Long id);
}
