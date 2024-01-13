package com.ruoyi.examine.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.examine.domain.ExaminePhysical;
import com.ruoyi.examine.service.IExaminePhysicalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据信息Controller
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@RestController
@RequestMapping("/system/examinePhysical")
public class ExaminePhysicalController extends BaseController
{
    @Resource
    private IExaminePhysicalService examinePhysicalService;

    /**
     * 查询数据信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExaminePhysical examinePhysical)
    {
        startPage();
        List<ExaminePhysical> list = examinePhysicalService.selectExaminePhysicalList(examinePhysical);
        return getDataTable(list);
    }

    /**
     * 导出数据信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:export')")
    @Log(title = "数据信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExaminePhysical examinePhysical)
    {
        List<ExaminePhysical> list = examinePhysicalService.selectExaminePhysicalList(examinePhysical);
        ExcelUtil<ExaminePhysical> util = new ExcelUtil<ExaminePhysical>(ExaminePhysical.class);
        util.exportExcel(response, list, "数据信息数据");
    }

    /**
     * 获取数据信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examinePhysicalService.selectExaminePhysicalById(id));
    }

    /**
     * 新增数据信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:add')")
    @Log(title = "数据信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExaminePhysical examinePhysical)
    {
        return toAjax(examinePhysicalService.insertExaminePhysical(examinePhysical));
    }

    /**
     * 修改数据信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:edit')")
    @Log(title = "数据信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExaminePhysical examinePhysical)
    {
        return toAjax(examinePhysicalService.updateExaminePhysical(examinePhysical));
    }

    /**
     * 删除数据信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysical:remove')")
    @Log(title = "数据信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examinePhysicalService.deleteExaminePhysicalByIds(ids));
    }
}
