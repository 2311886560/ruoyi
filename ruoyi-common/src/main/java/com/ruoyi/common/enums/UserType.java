package com.ruoyi.common.enums;

/**
 * 用户类型
 *
 * @author ruoyi
 */
public enum UserType {
    SYSTEM_USER("00", "系统用户"), EXAMINE_ADMIN("10", "医务人员"),
    EXAMINE_PHYSICAL_USER("11", "医务数据管理人员"), RETIRED_USER("21", "退休老干部"),
    SYSTEM_ADMIN("99", "系统用户");

    private final String code;
    private final String info;

    UserType(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
