package com.ruoyi.examine.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import com.ruoyi.examine.domain.vo.ExaminePhysicalDetailVo;

/**
 * 数据明细Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface ExaminePhysicalDetailMapper
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
    public List<ExaminePhysicalDetailVo> selectExaminePhysicalDetailVoList(ExaminePhysicalDetailVo examinePhysicalDetailVo);

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
     * 删除数据明细
     *
     * @param id 数据明细主键
     * @return 结果
     */
    public int deleteExaminePhysicalDetailById(Long id);

    /**
     * 删除数据明细
     *
     * @param examineId 数据主键
     * @return 结果
     */
    public int deleteExaminePhysicalDetailByExamineId(Long examineId);

    /**
     * 批量删除数据明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExaminePhysicalDetailByIds(Long[] ids);
}
