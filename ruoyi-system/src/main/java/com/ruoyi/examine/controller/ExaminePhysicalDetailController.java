package com.ruoyi.examine.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.examine.domain.vo.ExaminePhysicalDetailVo;
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
import com.ruoyi.examine.domain.ExaminePhysicalDetail;
import com.ruoyi.examine.service.IExaminePhysicalDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据明细Controller
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@RestController
@RequestMapping("/system/examinePhysicalDetail")
public class ExaminePhysicalDetailController extends BaseController
{
    @Resource
    private IExaminePhysicalDetailService examinePhysicalDetailService;

    /**
     * 查询数据明细列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExaminePhysicalDetailVo examinePhysicalDetailVo)
    {
        startPage();
        List<ExaminePhysicalDetailVo> list = examinePhysicalDetailService.selectExaminePhysicalDetailVoList(examinePhysicalDetailVo);
        return getDataTable(list);
    }

    /**
     * 导出数据明细列表
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:export')")
    @Log(title = "数据明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExaminePhysicalDetail examinePhysicalDetail)
    {
        List<ExaminePhysicalDetail> list = examinePhysicalDetailService.selectExaminePhysicalDetailList(examinePhysicalDetail);
        ExcelUtil<ExaminePhysicalDetail> util = new ExcelUtil<ExaminePhysicalDetail>(ExaminePhysicalDetail.class);
        util.exportExcel(response, list, "数据明细数据");
    }

    /**
     * 获取数据明细详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examinePhysicalDetailService.selectExaminePhysicalDetailById(id));
    }

    /**
     * 新增数据明细
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:add')")
    @Log(title = "数据明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExaminePhysicalDetail examinePhysicalDetail)
    {
        return toAjax(examinePhysicalDetailService.insertExaminePhysicalDetail(examinePhysicalDetail));
    }

    /**
     * 修改数据明细
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:edit')")
    @Log(title = "数据明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExaminePhysicalDetail examinePhysicalDetail)
    {
        return toAjax(examinePhysicalDetailService.updateExaminePhysicalDetail(examinePhysicalDetail));
    }

    /**
     * 删除数据明细
     */
//    @PreAuthorize("@ss.hasPermi('system:examinePhysicalDetail:remove')")
    @Log(title = "数据明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examinePhysicalDetailService.deleteExaminePhysicalDetailByIds(ids));
    }
}
