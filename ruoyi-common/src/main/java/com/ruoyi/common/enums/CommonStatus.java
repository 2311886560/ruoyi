package com.ruoyi.common.enums;

/**
 * 通用状态
 *
 * @author ruoyi
 */
public enum CommonStatus
{
    NORMAL("1", "有效"), INVALID("0", "失效");

    private final String code;
    private final String info;

    CommonStatus(String code, String info)
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
