package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExaminePhysicalAuthLogMapper;
import com.ruoyi.examine.domain.ExaminePhysicalAuthLog;
import com.ruoyi.examine.service.IExaminePhysicalAuthLogService;

/**
 * 数据审核记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-27
 */
@Service
public class ExaminePhysicalAuthLogServiceImpl implements IExaminePhysicalAuthLogService 
{
    @Autowired
    private ExaminePhysicalAuthLogMapper examinePhysicalAuthLogMapper;

    /**
     * 查询数据审核记录
     * 
     * @param id 数据审核记录主键
     * @return 数据审核记录
     */
    @Override
    public ExaminePhysicalAuthLog selectExaminePhysicalAuthLogById(Long id)
    {
        return examinePhysicalAuthLogMapper.selectExaminePhysicalAuthLogById(id);
    }

    /**
     * 查询数据审核记录列表
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 数据审核记录
     */
    @Override
    public List<ExaminePhysicalAuthLog> selectExaminePhysicalAuthLogList(ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        return examinePhysicalAuthLogMapper.selectExaminePhysicalAuthLogList(examinePhysicalAuthLog);
    }

    /**
     * 新增数据审核记录
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    @Override
    public int insertExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        examinePhysicalAuthLog.setCreateTime(DateUtils.getNowDate());
        return examinePhysicalAuthLogMapper.insertExaminePhysicalAuthLog(examinePhysicalAuthLog);
    }

    /**
     * 修改数据审核记录
     * 
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    @Override
    public int updateExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        examinePhysicalAuthLog.setUpdateTime(DateUtils.getNowDate());
        return examinePhysicalAuthLogMapper.updateExaminePhysicalAuthLog(examinePhysicalAuthLog);
    }

    /**
     * 批量删除数据审核记录
     * 
     * @param ids 需要删除的数据审核记录主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalAuthLogByIds(Long[] ids)
    {
        return examinePhysicalAuthLogMapper.deleteExaminePhysicalAuthLogByIds(ids);
    }

    /**
     * 删除数据审核记录信息
     * 
     * @param id 数据审核记录主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalAuthLogById(Long id)
    {
        return examinePhysicalAuthLogMapper.deleteExaminePhysicalAuthLogById(id);
    }
}
