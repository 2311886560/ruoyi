package com.ruoyi.examine.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据审核记录对象 examine_physical_auth_log
 * 
 * @author ruoyi
 * @date 2024-01-27
 */
public class ExaminePhysicalAuthLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 体检数据ID */
    @Excel(name = "体检数据ID")
    private Long examineId;

    /** 审核人 */
    @Excel(name = "审核人")
    private String authUser;

    /** 审核人ID */
    @Excel(name = "审核人ID")
    private Long authUserId;

    /** 审核状态 0=审核通过，1=审核不通过 */
    @Excel(name = "审核状态 0=审核通过，1=审核不通过")
    private String authStatus;

    /** 审核原因 */
    @Excel(name = "审核原因")
    private String reason;

    /** 删除标志 */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setExamineId(Long examineId) 
    {
        this.examineId = examineId;
    }

    public Long getExamineId() 
    {
        return examineId;
    }
    public void setAuthUser(String authUser) 
    {
        this.authUser = authUser;
    }

    public String getAuthUser() 
    {
        return authUser;
    }
    public void setAuthUserId(Long authUserId) 
    {
        this.authUserId = authUserId;
    }

    public Long getAuthUserId() 
    {
        return authUserId;
    }
    public void setAuthStatus(String authStatus) 
    {
        this.authStatus = authStatus;
    }

    public String getAuthStatus() 
    {
        return authStatus;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examineId", getExamineId())
            .append("authUser", getAuthUser())
            .append("authUserId", getAuthUserId())
            .append("authStatus", getAuthStatus())
            .append("reason", getReason())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
