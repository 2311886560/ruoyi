package com.ruoyi.common.enums;

/**
 * 通用删除状态
 *
 * @author ruoyi
 */
public enum CommonDelFlag
{
    UNDELETED("0", "未删除"), DELETED("1", "已删除");

    private final String code;
    private final String info;

    CommonDelFlag(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
