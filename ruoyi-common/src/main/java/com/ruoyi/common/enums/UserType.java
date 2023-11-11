package com.ruoyi.common.enums;

/**
 * 用户类型
 *
 * @author ruoyi
 */
public enum UserType {
    SYSTEM_USER("00", "系统用户"), FACTORY_ADMIN("10", "工厂负责人"),
    FACTORY_ORDER_USER("11", "工厂订单管理员"), FACTORY_USER("21", "工厂客户"),
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
