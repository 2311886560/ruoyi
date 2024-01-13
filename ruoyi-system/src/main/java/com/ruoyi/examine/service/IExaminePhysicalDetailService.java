package com.ruoyi.examine.service;

import java.util.List;

import com.ruoyi.examine.domain.ExaminePhysicalDetail;

/**
 * 数据明细Service接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface IExaminePhysicalDetailService
{
    /**
     * 查询数据明细
     *
     * @param id 数据明细主键
     * @return 数据明细
     */
    public ExaminePhysicalDetail selectExaminePhysicalDetailById(Long id);

    /**
     * 查询数据明细列表
     *
     * @param examinePhysicalDetail 数据明细
     * @return 数据明细集合
     */
    public List<ExaminePhysicalDetail> selectExaminePhysicalDetailList(ExaminePhysicalDetail examinePhysicalDetail);

    /**
     * 新增数据明细
     *
     * @param examinePhysicalDetail 数据明细
     * @return 结果
     */
    public int insertExaminePhysicalDetail(ExaminePhysicalDetail examinePhysicalDetail);

    /**
     * 修改数据明细
     *
     * @param examinePhysicalDetail 数据明细
     * @return 结果
     */
    public int updateExaminePhysicalDetail(ExaminePhysicalDetail examinePhysicalDetail);

    /**
     * 批量删除数据明细
     *
     * @param ids 需要删除的数据明细主键集合
     * @return 结果
     */
    public int deleteExaminePhysicalDetailByIds(Long[] ids);

    /**
     * 删除数据明细信息
     *
     * @param id 数据明细主键
     * @return 结果
     */
    public int deleteExaminePhysicalDetailById(Long id);
}
