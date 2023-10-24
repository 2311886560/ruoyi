package com.ruoyi.factory.domain;

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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEntCode(String entCode)
    {
        this.entCode = entCode;
    }

    public String getEntCode()
    {
        return entCode;
    }
    public void setCreditCode(String creditCode)
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode()
    {
        return creditCode;
    }
    public void setEntName(String entName)
    {
        this.entName = entName;
    }

    public String getEntName()
    {
        return entName;
    }
    public void setLegalPerson(String legalPerson)
    {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson()
    {
        return legalPerson;
    }
    public void setLegalPhone(String legalPhone)
    {
        this.legalPhone = legalPhone;
    }

    public String getLegalPhone()
    {
        return legalPhone;
    }
    public void setLinkerMan(String linkerMan)
    {
        this.linkerMan = linkerMan;
    }

    public String getLinkerMan()
    {
        return linkerMan;
    }
    public void setLinkerPhone(String linkerPhone)
    {
        this.linkerPhone = linkerPhone;
    }

    public String getLinkerPhone()
    {
        return linkerPhone;
    }
    public void setWorkPhone(String workPhone)
    {
        this.workPhone = workPhone;
    }

    public String getWorkPhone()
    {
        return workPhone;
    }
    public void setEntAddress(String entAddress)
    {
        this.entAddress = entAddress;
    }

    public String getEntAddress()
    {
        return entAddress;
    }
    public void setLicense(String license)
    {
        this.license = license;
    }

    public String getLicense()
    {
        return license;
    }
    public void setLicensePic(String licensePic)
    {
        this.licensePic = licensePic;
    }

    public String getLicensePic()
    {
        return licensePic;
    }
    public void setBusScope(String busScope)
    {
        this.busScope = busScope;
    }

    public String getBusScope()
    {
        return busScope;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
            .append("entCode", getEntCode())
            .append("creditCode", getCreditCode())
            .append("entName", getEntName())
            .append("legalPerson", getLegalPerson())
            .append("legalPhone", getLegalPhone())
            .append("linkerMan", getLinkerMan())
            .append("linkerPhone", getLinkerPhone())
            .append("workPhone", getWorkPhone())
            .append("entAddress", getEntAddress())
            .append("license", getLicense())
            .append("licensePic", getLicensePic())
            .append("remark", getRemark())
            .append("busScope", getBusScope())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
