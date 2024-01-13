package com.ruoyi.examine.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 干休所信息对象 retired
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Data
public class Retired extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 干休所ID */
    private Long id;

    /** 干休所名称 */
    @Excel(name = "干休所名称")
    private String name;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 负责单位 */
    @Excel(name = "负责单位")
    private String unit;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 负责人 */
    @Excel(name = "负责人")
    private String head;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
