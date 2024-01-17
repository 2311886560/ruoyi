package com.ruoyi.examine.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.CommonDelFlag;
import com.ruoyi.common.enums.CommonStatus;
import com.ruoyi.common.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import com.ruoyi.examine.domain.vo.ExaminePhysicalVo;
import com.ruoyi.examine.service.IExaminePhysicalDetailService;
import org.springframework.stereotype.Service;
import com.ruoyi.examine.mapper.ExaminePhysicalMapper;
import com.ruoyi.examine.domain.ExaminePhysical;
import com.ruoyi.examine.service.IExaminePhysicalService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 数据信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Service
public class ExaminePhysicalServiceImpl extends ServiceImpl<ExaminePhysicalMapper, ExaminePhysical> implements IExaminePhysicalService
{
    @Resource
    private ExaminePhysicalMapper examinePhysicalMapper;
    @Resource
    private IExaminePhysicalDetailService iExaminePhysicalDetailService;

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
        LambdaQueryWrapper<ExaminePhysicalDetail> physicalDetailLambdaQueryWrapper = Wrappers.lambdaQuery();
        physicalDetailLambdaQueryWrapper.eq(ExaminePhysicalDetail::getExamineId, examinePhysicalVo.getId());
        physicalDetailLambdaQueryWrapper.eq(ExaminePhysicalDetail::getDelFlag, CommonDelFlag.UNDELETED.getCode());
        List<ExaminePhysicalDetail> examinePhysicalDetailList = iExaminePhysicalDetailService.list(physicalDetailLambdaQueryWrapper);
        examinePhysicalVo.setExaminePhysicalDetailList(examinePhysicalDetailList);
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
    @Transactional(rollbackFor = Exception.class)
    public int insertExaminePhysical(ExaminePhysicalVo examinePhysicalVo)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        // 初始化
        if (StringUtils.isEmpty(examinePhysicalVo.getStatus())) {
            examinePhysicalVo.setStatus(CommonStatus.NORMAL.getCode());
        }
        if (StringUtils.isEmpty(examinePhysicalVo.getDelFlag())) {
            examinePhysicalVo.setDelFlag(CommonDelFlag.UNDELETED.getCode());
        }
        examinePhysicalVo.setCreateBy(user.getNickName());
        examinePhysicalVo.setCreateTime(nowDate);
        examinePhysicalVo.setUpdateBy(user.getNickName());
        examinePhysicalVo.setUpdateTime(nowDate);
        int i = examinePhysicalMapper.insertExaminePhysical(examinePhysicalVo);
        // 先删除旧子表数据再更新
        LambdaQueryWrapper<ExaminePhysicalDetail> physicalDetailLambdaQueryWrapper = Wrappers.lambdaQuery();
        physicalDetailLambdaQueryWrapper.eq(ExaminePhysicalDetail::getExamineId, examinePhysicalVo.getId());
        iExaminePhysicalDetailService.remove(physicalDetailLambdaQueryWrapper);

        List<ExaminePhysicalDetail> examinePhysicalDetailList = examinePhysicalVo.getExaminePhysicalDetailList();
        if (StringUtils.isNotEmpty(examinePhysicalDetailList)) {
            for (ExaminePhysicalDetail examinePhysicalDetail : examinePhysicalDetailList) {
                examinePhysicalDetail.setExamineId(examinePhysicalVo.getId());
            }
            iExaminePhysicalDetailService.saveBatch(examinePhysicalDetailList);
        }

        return i;
    }

    /**
     * 修改数据信息
     *
     * @param examinePhysicalVo 数据信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateExaminePhysical(ExaminePhysicalVo examinePhysicalVo)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        Date nowDate = DateUtils.getNowDate();
        examinePhysicalVo.setUpdateBy(user.getNickName());
        examinePhysicalVo.setUpdateTime(nowDate);
        int i = examinePhysicalMapper.updateExaminePhysical(examinePhysicalVo);
        // 先删除旧子表数据再更新
        LambdaQueryWrapper<ExaminePhysicalDetail> physicalDetailLambdaQueryWrapper = Wrappers.lambdaQuery();
        physicalDetailLambdaQueryWrapper.eq(ExaminePhysicalDetail::getExamineId, examinePhysicalVo.getId());
        iExaminePhysicalDetailService.remove(physicalDetailLambdaQueryWrapper);

        List<ExaminePhysicalDetail> examinePhysicalDetailList = examinePhysicalVo.getExaminePhysicalDetailList();
        if (StringUtils.isNotEmpty(examinePhysicalDetailList)) {
            for (ExaminePhysicalDetail examinePhysicalDetail : examinePhysicalDetailList) {
                examinePhysicalDetail.setExamineId(examinePhysicalVo.getId());
            }
            iExaminePhysicalDetailService.saveBatch(examinePhysicalDetailList);
        }
        return i;
    }

    /**
     * 批量删除数据信息
     *
     * @param ids 需要删除的数据信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public int deleteExaminePhysicalById(Long id)
    {
        return examinePhysicalMapper.deleteExaminePhysicalById(id);
    }
}
