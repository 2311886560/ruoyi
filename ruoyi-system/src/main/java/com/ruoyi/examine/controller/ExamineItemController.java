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
import com.ruoyi.examine.domain.ExamineItem;
import com.ruoyi.examine.service.IExamineItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项Controller
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@RestController
@RequestMapping("/system/examineItem")
public class ExamineItemController extends BaseController
{
    @Resource
    private IExamineItemService examineItemService;

    /**
     * 查询项列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamineItem examineItem)
    {
        startPage();
        List<ExamineItem> list = examineItemService.selectExamineItemList(examineItem);
        return getDataTable(list);
    }

    /**
     * 导出项列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:export')")
    @Log(title = "项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamineItem examineItem)
    {
        List<ExamineItem> list = examineItemService.selectExamineItemList(examineItem);
        ExcelUtil<ExamineItem> util = new ExcelUtil<ExamineItem>(ExamineItem.class);
        util.exportExcel(response, list, "项数据");
    }

    /**
     * 获取项详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examineItemService.selectExamineItemById(id));
    }

    /**
     * 新增项
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:add')")
    @Log(title = "项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamineItem examineItem)
    {
        return toAjax(examineItemService.insertExamineItem(examineItem));
    }

    /**
     * 修改项
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:edit')")
    @Log(title = "项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamineItem examineItem)
    {
        return toAjax(examineItemService.updateExamineItem(examineItem));
    }

    /**
     * 删除项
     */
//    @PreAuthorize("@ss.hasPermi('system:examineItem:remove')")
    @Log(title = "项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examineItemService.deleteExamineItemByIds(ids));
    }
}
