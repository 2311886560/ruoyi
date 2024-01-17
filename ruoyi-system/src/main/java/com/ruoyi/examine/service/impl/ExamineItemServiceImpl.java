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
import com.ruoyi.examine.mapper.ExamineItemMapper;
import com.ruoyi.examine.domain.ExamineItem;
import com.ruoyi.examine.service.IExamineItemService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 体检项Service业务层处理
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
     * 查询体检项
     *
     * @param id 体检项主键
     * @return 体检项
     */
    @Override
    public ExamineItem selectExamineItemById(Long id)
    {
        return examineItemMapper.selectExamineItemById(id);
    }

    /**
     * 查询体检项列表
     *
     * @param examineItem 体检项
     * @return 体检项
     */
    @Override
    public List<ExamineItem> selectExamineItemList(ExamineItem examineItem)
    {
        return examineItemMapper.selectExamineItemList(examineItem);
    }

    /**
     * 新增体检项
     *
     * @param examineItem 体检项
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertExamineItem(ExamineItem examineItem)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        // 初始化
        if (StringUtils.isEmpty(examineItem.getStatus())) {
            examineItem.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(examineItem.getDelFlag())) {
            examineItem.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        examineItem.setCreateBy(user.getNickName());
        examineItem.setCreateTime(nowDate);
        examineItem.setUpdateBy(user.getNickName());
        examineItem.setUpdateTime(nowDate);
        return examineItemMapper.insertExamineItem(examineItem);
    }

    /**
     * 修改体检项
     *
     * @param examineItem 体检项
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateExamineItem(ExamineItem examineItem)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        examineItem.setUpdateBy(user.getNickName());
        examineItem.setUpdateTime(nowDate);
        return examineItemMapper.updateExamineItem(examineItem);
    }

    /**
     * 批量删除体检项
     *
     * @param ids 需要删除的体检项主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteExamineItemByIds(Long[] ids)
    {
        return examineItemMapper.deleteExamineItemByIds(ids);
    }

    /**
     * 删除体检项信息
     *
     * @param id 体检项主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteExamineItemById(Long id)
    {
        return examineItemMapper.deleteExamineItemById(id);
    }
}
