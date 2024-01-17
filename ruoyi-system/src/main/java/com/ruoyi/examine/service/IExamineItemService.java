package com.ruoyi.examine.service;

import java.util.List;

import com.ruoyi.examine.domain.ExamineItem;

/**
 * 体检项Service接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface IExamineItemService
{
    /**
     * 查询体检项
     *
     * @param id 体检项主键
     * @return 体检项
     */
    public ExamineItem selectExamineItemById(Long id);

    /**
     * 查询体检项列表
     *
     * @param examineItem 体检项
     * @return 体检项集合
     */
    public List<ExamineItem> selectExamineItemList(ExamineItem examineItem);

    /**
     * 新增体检项
     *
     * @param examineItem 体检项
     * @return 结果
     */
    public int insertExamineItem(ExamineItem examineItem);

    /**
     * 修改体检项
     *
     * @param examineItem 体检项
     * @return 结果
     */
    public int updateExamineItem(ExamineItem examineItem);

    /**
     * 批量删除体检项
     *
     * @param ids 需要删除的体检项主键集合
     * @return 结果
     */
    public int deleteExamineItemByIds(Long[] ids);

    /**
     * 删除体检项信息
     *
     * @param id 体检项主键
     * @return 结果
     */
    public int deleteExamineItemById(Long id);
}
