package com.ruoyi.examine.service;

import java.util.List;

import com.ruoyi.examine.domain.ExamineItem;

/**
 * 项Service接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface IExamineItemService
{
    /**
     * 查询项
     *
     * @param id 项主键
     * @return 项
     */
    public ExamineItem selectExamineItemById(Long id);

    /**
     * 查询项列表
     *
     * @param examineItem 项
     * @return 项集合
     */
    public List<ExamineItem> selectExamineItemList(ExamineItem examineItem);

    /**
     * 新增项
     *
     * @param examineItem 项
     * @return 结果
     */
    public int insertExamineItem(ExamineItem examineItem);

    /**
     * 修改项
     *
     * @param examineItem 项
     * @return 结果
     */
    public int updateExamineItem(ExamineItem examineItem);

    /**
     * 批量删除项
     *
     * @param ids 需要删除的项主键集合
     * @return 结果
     */
    public int deleteExamineItemByIds(Long[] ids);

    /**
     * 删除项信息
     *
     * @param id 项主键
     * @return 结果
     */
    public int deleteExamineItemById(Long id);
}
