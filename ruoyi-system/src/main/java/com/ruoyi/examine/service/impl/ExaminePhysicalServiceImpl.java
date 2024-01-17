package com.ruoyi.examine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.examine.domain.vo.ExaminePhysicalVo;
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
    public ExaminePhysicalVo selectExaminePhysicalById(Long id)
    {
        ExaminePhysicalVo examinePhysicalVo = examinePhysicalMapper.selectExaminePhysicalById(id);
        return examinePhysicalVo;
    }

    /**
     * 查询数据信息列表
     *
     * @param examinePhysicalVo 数据信息
     * @return 数据信息
     */
    @Override
    public List<ExaminePhysicalVo> selectExaminePhysicalList(ExaminePhysicalVo examinePhysicalVo)
    {
        List<ExaminePhysicalVo> examinePhysicalVoList = examinePhysicalMapper.selectExaminePhysicalList(examinePhysicalVo);
        return examinePhysicalVoList;
    }

    /**
     * 新增数据信息
     *
     * @param examinePhysicalVo 数据信息
     * @return 结果
     */
    @Override
    public int insertExaminePhysical(ExaminePhysicalVo examinePhysicalVo)
    {
        examinePhysicalVo.setCreateTime(DateUtils.getNowDate());
        int i = examinePhysicalMapper.insertExaminePhysical(examinePhysicalVo);
        return i;
    }

    /**
     * 修改数据信息
     *
     * @param examinePhysicalVo 数据信息
     * @return 结果
     */
    @Override
    public int updateExaminePhysical(ExaminePhysicalVo examinePhysicalVo)
    {
        examinePhysicalVo.setUpdateTime(DateUtils.getNowDate());
        int i = examinePhysicalMapper.updateExaminePhysical(examinePhysicalVo);
        return i;
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
