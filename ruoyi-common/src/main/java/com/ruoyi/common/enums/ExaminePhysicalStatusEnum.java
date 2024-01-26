package com.ruoyi.common.enums;

import java.util.Arrays;

/**
 * 体检数据状态枚举类
 */
public enum ExaminePhysicalStatusEnum {

    WAIT_AUTH("0", "待审核"),
    AUTH_SUCCESS("1", "审核通过"),
    AUTH_REFUSE("2", "审核不通过");

    private final String code;
    private final String name;

    ExaminePhysicalStatusEnum(String code, String msg) {
        this.code = code;
        this.name = msg;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public static String getNameByCode(String code) {
        ExaminePhysicalStatusEnum statusEnum = Arrays.stream(ExaminePhysicalStatusEnum.values())
                .filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
        return statusEnum == null ? "未知" : statusEnum.getName();
    }

    public static String getCodeByName(String name) {
        ExaminePhysicalStatusEnum statusEnum = Arrays.stream(ExaminePhysicalStatusEnum.values())
                        .filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        return statusEnum == null ? null : statusEnum.getCode();
    }

}
