package com.ruoyi.examine.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据信息对象 examine_physical
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Data
public class ExaminePhysical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 体检数据ID */
    private Long id;

    /** 医务人员用户ID */
    @Excel(name = "医务人员用户ID")
    private Long medicalUserId;

    /** 老干部用户ID */
    @Excel(name = "老干部用户ID")
    private Long retiredUserId;

    /** 体检标题 */
    @Excel(name = "体检标题")
    private String title;

    /** 体检内容 */
    @Excel(name = "体检内容")
    private String content;

    /** 体检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "体检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examineTime;

    /** 审核状态：0=未审核，1=审核通过，2=审核不通过 */
    @Excel(name = "审核状态：0=未审核，1=审核通过，2=审核不通过")
    private String processStatus;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
