package com.ruoyi.examine.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExaminePhysicalDetailMapper;
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import com.ruoyi.examine.service.IExaminePhysicalDetailService;

import javax.annotation.Resource;

/**
 * 数据明细Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class ExaminePhysicalDetailServiceImpl implements IExaminePhysicalDetailService
{
    @Resource
    private ExaminePhysicalDetailMapper examinePhysicalDetailMapper;

    /**
     * 查询数据明细
     *
     * @param id 数据明细主键
     * @return 数据明细
     */
    @Override
    public ExaminePhysicalDetail selectExaminePhysicalDetailById(Long id)
    {
        return examinePhysicalDetailMapper.selectExaminePhysicalDetailById(id);
    }

    /**
     * 查询数据明细列表
     *
     * @param examinePhysicalDetail 数据明细
     * @return 数据明细
     */
    @Override
    public List<ExaminePhysicalDetail> selectExaminePhysicalDetailList(ExaminePhysicalDetail examinePhysicalDetail)
    {
        return examinePhysicalDetailMapper.selectExaminePhysicalDetailList(examinePhysicalDetail);
    }

    /**
     * 新增数据明细
     *
     * @param examinePhysicalDetail 数据明细
     * @return 结果
     */
    @Override
    public int insertExaminePhysicalDetail(ExaminePhysicalDetail examinePhysicalDetail)
    {
        examinePhysicalDetail.setCreateTime(DateUtils.getNowDate());
        return examinePhysicalDetailMapper.insertExaminePhysicalDetail(examinePhysicalDetail);
    }

    /**
     * 修改数据明细
     *
     * @param examinePhysicalDetail 数据明细
     * @return 结果
     */
    @Override
    public int updateExaminePhysicalDetail(ExaminePhysicalDetail examinePhysicalDetail)
    {
        examinePhysicalDetail.setUpdateTime(DateUtils.getNowDate());
        return examinePhysicalDetailMapper.updateExaminePhysicalDetail(examinePhysicalDetail);
    }

    /**
     * 批量删除数据明细
     *
     * @param ids 需要删除的数据明细主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalDetailByIds(Long[] ids)
    {
        return examinePhysicalDetailMapper.deleteExaminePhysicalDetailByIds(ids);
    }

    /**
     * 删除数据明细信息
     *
     * @param id 数据明细主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalDetailById(Long id)
    {
        return examinePhysicalDetailMapper.deleteExaminePhysicalDetailById(id);
    }
}
