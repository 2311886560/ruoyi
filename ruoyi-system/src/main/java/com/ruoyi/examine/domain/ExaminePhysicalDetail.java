package com.ruoyi.examine.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据明细对象 examine_physical_detail
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Data
public class ExaminePhysicalDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 体检数据明细ID */
    private Long id;

    /** 体检数据ID */
    @Excel(name = "体检数据ID")
    private Long examineId;

    /** 体检项ID */
    @Excel(name = "体检项ID")
    private String itemId;

    /** 体检项名称 */
    @Excel(name = "体检项名称")
    private String name;

    /** 体检值 */
    @Excel(name = "体检值")
    private String value;

    /** 参考值 */
    @Excel(name = "参考值")
    private String referenceValue;

    /** 体检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "体检时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date examineTime;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
