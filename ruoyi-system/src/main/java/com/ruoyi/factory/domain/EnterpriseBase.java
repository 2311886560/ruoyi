package com.ruoyi.factory.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工厂基本信息对象 enterprise_base
 *
 * @author ruoyi
 * @date 2023-10-24
 */
@Data
public class EnterpriseBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private String entCode;

    /** 统一信用代码 */
    @Excel(name = "统一信用代码")
    private String creditCode;

    /** 工厂名称 */
    @Excel(name = "工厂名称")
    private String entName;

    /** 法人 */
    @Excel(name = "法人")
    private String legalPerson;

    /** 法人手机号 */
    @Excel(name = "法人手机号")
    private String legalPhone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String linkerMan;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String linkerPhone;

    /** 单位联系电话 */
    @Excel(name = "单位联系电话")
    private String workPhone;

    /** 公司详细地址 */
    @Excel(name = "公司详细地址")
    private String entAddress;

    /** 营业执照号 */
    @Excel(name = "营业执照号")
    private String license;

    /** 营业执照图片地址 */
    @Excel(name = "营业执照图片地址")
    private String licensePic;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String busScope;

    /** 状态：0=失效，1=有效 */
    @Excel(name = "状态：0=失效，1=有效")
    private String status;

    /** 删除状态：0=未删除，1=已删除 */
    private String delFlag;
}
