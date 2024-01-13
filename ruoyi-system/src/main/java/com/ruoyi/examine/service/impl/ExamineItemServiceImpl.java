package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExamineItemMapper;
import com.ruoyi.examine.domain.ExamineItem;
import com.ruoyi.examine.service.IExamineItemService;

import javax.annotation.Resource;

/**
 * 项Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class ExamineItemServiceImpl implements IExamineItemService
{
    @Resource
    private ExamineItemMapper examineItemMapper;

    /**
     * 查询项
     *
     * @param id 项主键
     * @return 项
     */
    @Override
    public ExamineItem selectExamineItemById(Long id)
    {
        return examineItemMapper.selectExamineItemById(id);
    }

    /**
     * 查询项列表
     *
     * @param examineItem 项
     * @return 项
     */
    @Override
    public List<ExamineItem> selectExamineItemList(ExamineItem examineItem)
    {
        return examineItemMapper.selectExamineItemList(examineItem);
    }

    /**
     * 新增项
     *
     * @param examineItem 项
     * @return 结果
     */
    @Override
    public int insertExamineItem(ExamineItem examineItem)
    {
        examineItem.setCreateTime(DateUtils.getNowDate());
        return examineItemMapper.insertExamineItem(examineItem);
    }

    /**
     * 修改项
     *
     * @param examineItem 项
     * @return 结果
     */
    @Override
    public int updateExamineItem(ExamineItem examineItem)
    {
        examineItem.setUpdateTime(DateUtils.getNowDate());
        return examineItemMapper.updateExamineItem(examineItem);
    }

    /**
     * 批量删除项
     *
     * @param ids 需要删除的项主键
     * @return 结果
     */
    @Override
    public int deleteExamineItemByIds(Long[] ids)
    {
        return examineItemMapper.deleteExamineItemByIds(ids);
    }

    /**
     * 删除项信息
     *
     * @param id 项主键
     * @return 结果
     */
    @Override
    public int deleteExamineItemById(Long id)
    {
        return examineItemMapper.deleteExamineItemById(id);
    }
}
