package com.ruoyi.examine.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.examine.domain.ExaminePhysicalAuthLog;
import com.ruoyi.examine.service.IExaminePhysicalAuthLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据审核记录Controller
 * 
 * @author ruoyi
 * @date 2024-01-27
 */
@RestController
@RequestMapping("/system/examinePhysicalAuthLog")
public class ExaminePhysicalAuthLogController extends BaseController
{
    @Autowired
    private IExaminePhysicalAuthLogService examinePhysicalAuthLogService;

    /**
     * 查询数据审核记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        startPage();
        List<ExaminePhysicalAuthLog> list = examinePhysicalAuthLogService.selectExaminePhysicalAuthLogList(examinePhysicalAuthLog);
        return getDataTable(list);
    }

    /**
     * 导出数据审核记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:export')")
    @Log(title = "数据审核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        List<ExaminePhysicalAuthLog> list = examinePhysicalAuthLogService.selectExaminePhysicalAuthLogList(examinePhysicalAuthLog);
        ExcelUtil<ExaminePhysicalAuthLog> util = new ExcelUtil<ExaminePhysicalAuthLog>(ExaminePhysicalAuthLog.class);
        util.exportExcel(response, list, "数据审核记录数据");
    }

    /**
     * 获取数据审核记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examinePhysicalAuthLogService.selectExaminePhysicalAuthLogById(id));
    }

    /**
     * 新增数据审核记录
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:add')")
    @Log(title = "数据审核记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        return toAjax(examinePhysicalAuthLogService.insertExaminePhysicalAuthLog(examinePhysicalAuthLog));
    }

    /**
     * 修改数据审核记录
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:edit')")
    @Log(title = "数据审核记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExaminePhysicalAuthLog examinePhysicalAuthLog)
    {
        return toAjax(examinePhysicalAuthLogService.updateExaminePhysicalAuthLog(examinePhysicalAuthLog));
    }

    /**
     * 删除数据审核记录
     */
    @PreAuthorize("@ss.hasPermi('system:examinePhysicalAuthLog:remove')")
    @Log(title = "数据审核记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examinePhysicalAuthLogService.deleteExaminePhysicalAuthLogByIds(ids));
    }
}
