package com.ruoyi.examine.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.examine.domain.ExaminePhysical;
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import lombok.Data;

import java.util.List;

@Data
public class ExaminePhysicalVo extends ExaminePhysical
{
    List<ExaminePhysicalDetail> examinePhysicalDetailList;

    /** 医务人员 */
    private String medicalUserName;

    /** 老干部 */
    private String retiredUserName;
}
