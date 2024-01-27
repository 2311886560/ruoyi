package com.ruoyi.examine.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.enums.ExaminePhysicalAuthStatusEnum;
import com.ruoyi.common.enums.ExaminePhysicalStatusEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.examine.domain.ExaminePhysical;
import com.ruoyi.examine.mapper.ExaminePhysicalMapper;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExaminePhysicalAuthLogMapper;
import com.ruoyi.examine.domain.ExaminePhysicalAuthLog;
import com.ruoyi.examine.service.IExaminePhysicalAuthLogService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 数据审核记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-27
 */
@Service
public class ExaminePhysicalAuthLogServiceImpl implements IExaminePhysicalAuthLogService {
    @Autowired
    private ExaminePhysicalAuthLogMapper examinePhysicalAuthLogMapper;
    @Autowired
    private ExaminePhysicalMapper examinePhysicalMapper;

    /**
     * 查询数据审核记录
     *
     * @param id 数据审核记录主键
     * @return 数据审核记录
     */
    @Override
    public ExaminePhysicalAuthLog selectExaminePhysicalAuthLogById(Long id) {
        return examinePhysicalAuthLogMapper.selectExaminePhysicalAuthLogById(id);
    }

    /**
     * 查询数据审核记录列表
     *
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 数据审核记录
     */
    @Override
    public List<ExaminePhysicalAuthLog> selectExaminePhysicalAuthLogList(ExaminePhysicalAuthLog examinePhysicalAuthLog) {
        return examinePhysicalAuthLogMapper.selectExaminePhysicalAuthLogList(examinePhysicalAuthLog);
    }

    /**
     * 新增数据审核记录
     *
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        if (StringUtils.isNull(examinePhysicalAuthLog.getExamineId())) {
            throw new ServiceException("体检数据不存在");
        }

        // 初始化
        if (StringUtils.isEmpty(examinePhysicalAuthLog.getDelFlag())) {
            examinePhysicalAuthLog.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        examinePhysicalAuthLog.setAuthUserId(user.getUserId());
        examinePhysicalAuthLog.setAuthUser(user.getNickName());
        examinePhysicalAuthLog.setCreateBy(user.getNickName());
        examinePhysicalAuthLog.setCreateTime(nowDate);
        examinePhysicalAuthLog.setUpdateBy(user.getNickName());
        examinePhysicalAuthLog.setUpdateTime(nowDate);
        int i = examinePhysicalAuthLogMapper.insertExaminePhysicalAuthLog(examinePhysicalAuthLog);
        // 修改主表状态
        if (StringUtils.isNotEmpty(examinePhysicalAuthLog.getAuthStatus())) {
            ExaminePhysical examinePhysical = new ExaminePhysical();
            examinePhysical.setId(examinePhysicalAuthLog.getExamineId());
            if (StringUtils.equals(ExaminePhysicalAuthStatusEnum.WAIT_ACCEPT.getCode(), examinePhysicalAuthLog.getAuthStatus())) {
                examinePhysical.setStatus(ExaminePhysicalStatusEnum.AUTH_SUCCESS.getCode());
            } else {
                examinePhysical.setStatus(ExaminePhysicalStatusEnum.AUTH_REFUSE.getCode());
            }
            examinePhysicalMapper.updateExaminePhysical(examinePhysical);
        }
        return i;
    }

    /**
     * 修改数据审核记录
     *
     * @param examinePhysicalAuthLog 数据审核记录
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateExaminePhysicalAuthLog(ExaminePhysicalAuthLog examinePhysicalAuthLog) {
        examinePhysicalAuthLog.setUpdateTime(DateUtils.getNowDate());
        return examinePhysicalAuthLogMapper.updateExaminePhysicalAuthLog(examinePhysicalAuthLog);
    }

    /**
     * 批量删除数据审核记录
     *
     * @param ids 需要删除的数据审核记录主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalAuthLogByIds(Long[] ids) {
        return examinePhysicalAuthLogMapper.deleteExaminePhysicalAuthLogByIds(ids);
    }

    /**
     * 删除数据审核记录信息
     *
     * @param id 数据审核记录主键
     * @return 结果
     */
    @Override
    public int deleteExaminePhysicalAuthLogById(Long id) {
        return examinePhysicalAuthLogMapper.deleteExaminePhysicalAuthLogById(id);
    }
}
