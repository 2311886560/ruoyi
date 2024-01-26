package com.ruoyi.common.enums;

import java.util.Arrays;

/**
 * 审核状态枚举类
 */
public enum ExaminePhysicalAuthStatusEnum {
    WAIT_ACCEPT("0", "审核通过"),
    AUTH_REFUSE("1", "审核不通过");

    private final String code;
    private final String name;

    ExaminePhysicalAuthStatusEnum(String code, String msg) {
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
        ExaminePhysicalAuthStatusEnum statusEnum = Arrays.stream(ExaminePhysicalAuthStatusEnum.values())
                .filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
        return statusEnum == null ? "未知" : statusEnum.getName();
    }

    public static String getCodeByName(String name) {
        ExaminePhysicalAuthStatusEnum statusEnum = Arrays.stream(ExaminePhysicalAuthStatusEnum.values())
                        .filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        return statusEnum == null ? null : statusEnum.getCode();
    }

}
