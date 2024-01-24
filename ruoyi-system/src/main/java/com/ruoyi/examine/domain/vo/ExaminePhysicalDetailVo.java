package com.ruoyi.examine.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import lombok.Data;

import java.util.Date;

@Data
public class ExaminePhysicalDetailVo extends ExaminePhysicalDetail
{
    /** 老干部用户ID */
    @Excel(name = "老干部用户ID")
    private Long retiredUserId;
}
