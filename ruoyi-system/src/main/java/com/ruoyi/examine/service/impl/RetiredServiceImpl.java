package com.ruoyi.examine.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.RetiredMapper;
import com.ruoyi.examine.domain.Retired;
import com.ruoyi.examine.service.IRetiredService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 干休所信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class RetiredServiceImpl implements IRetiredService
{
    @Resource
    private RetiredMapper retiredMapper;

    /**
     * 查询干休所信息
     *
     * @param id 干休所信息主键
     * @return 干休所信息
     */
    @Override
    public Retired selectRetiredById(Long id)
    {
        return retiredMapper.selectRetiredById(id);
    }

    /**
     * 查询干休所信息列表
     *
     * @param retired 干休所信息
     * @return 干休所信息
     */
    @Override
    public List<Retired> selectRetiredList(Retired retired)
    {
        return retiredMapper.selectRetiredList(retired);
    }

    /**
     * 新增干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertRetired(Retired retired)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        // 初始化
        if (StringUtils.isEmpty(retired.getStatus())) {
            retired.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(retired.getDelFlag())) {
            retired.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        retired.setCreateBy(user.getNickName());
        retired.setCreateTime(nowDate);
        retired.setUpdateBy(user.getNickName());
        retired.setUpdateTime(nowDate);
        return retiredMapper.insertRetired(retired);
    }

    /**
     * 修改干休所信息
     *
     * @param retired 干休所信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRetired(Retired retired)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        retired.setUpdateBy(user.getNickName());
        retired.setUpdateTime(nowDate);
        return retiredMapper.updateRetired(retired);
    }

    /**
     * 批量删除干休所信息
     *
     * @param ids 需要删除的干休所信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRetiredByIds(Long[] ids)
    {
        return retiredMapper.deleteRetiredByIds(ids);
    }

    /**
     * 删除干休所信息信息
     *
     * @param id 干休所信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRetiredById(Long id)
    {
        return retiredMapper.deleteRetiredById(id);
    }
}
