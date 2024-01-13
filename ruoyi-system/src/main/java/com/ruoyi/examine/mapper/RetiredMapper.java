package com.ruoyi.examine.mapper;

import java.util.List;
import com.ruoyi.examine.domain.Retired;

/**
 * 干休所信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-13
 */
public interface RetiredMapper
{
    /**
     * 查询干休所信息
     *
     * @param id 干休所信息主键
     * @return 干休所信息
     */
    public Retired selectRetiredById(Long id);

    /**
     * 查询干休所信息列表
     *
     * @param retired 干休所信息
     * @return 干休所信息集合
     */
    public List<Retired> selectRetiredList(Retired retired);

    /**
     * 新增干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    public int insertRetired(Retired retired);

    /**
     * 修改干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    public int updateRetired(Retired retired);

    /**
     * 删除干休所信息
     *
     * @param id 干休所信息主键
     * @return 结果
     */
    public int deleteRetiredById(Long id);

    /**
     * 批量删除干休所信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRetiredByIds(Long[] ids);
}
