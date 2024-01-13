package com.ruoyi.examine.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医院信息对象 hospital
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Data
public class Hospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医院ID */
    private Long id;

    /** 医院名称 */
    @Excel(name = "医院名称")
    private String name;

    /** 医院社会代码 */
    @Excel(name = "医院社会代码")
    private String number;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
