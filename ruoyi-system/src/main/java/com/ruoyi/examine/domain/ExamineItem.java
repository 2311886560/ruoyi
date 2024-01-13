package com.ruoyi.examine.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项对象 examine_item
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@Data
public class ExamineItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 体检项ID */
    private Long id;

    /** 体检项名称 */
    @Excel(name = "体检项名称")
    private String name;

    /** 参考值 */
    @Excel(name = "参考值")
    private String referenceValue;

    /** 是否为默认：0=默认，1=不默认 */
    @Excel(name = "是否为默认：0=默认，1=不默认")
    private String defaultStatus;

    /** 是否显示在个人中心：0=显示，1=不显示 */
    @Excel(name = "是否显示在个人中心：0=显示，1=不显示")
    private String showUser;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
