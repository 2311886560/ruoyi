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
import com.ruoyi.examine.domain.Retired;
import com.ruoyi.examine.service.IRetiredService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 干休所信息Controller
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@RestController
@RequestMapping("/system/retired")
public class RetiredController extends BaseController
{
    @Resource
    private IRetiredService retiredService;

    /**
     * 查询干休所信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:list')")
    @GetMapping("/list")
    public TableDataInfo list(Retired retired)
    {
        startPage();
        List<Retired> list = retiredService.selectRetiredList(retired);
        return getDataTable(list);
    }

    /**
     * 导出干休所信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:export')")
    @Log(title = "干休所信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Retired retired)
    {
        List<Retired> list = retiredService.selectRetiredList(retired);
        ExcelUtil<Retired> util = new ExcelUtil<Retired>(Retired.class);
        util.exportExcel(response, list, "干休所信息数据");
    }

    /**
     * 获取干休所信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(retiredService.selectRetiredById(id));
    }

    /**
     * 新增干休所信息
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:add')")
    @Log(title = "干休所信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Retired retired)
    {
        return toAjax(retiredService.insertRetired(retired));
    }

    /**
     * 修改干休所信息
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:edit')")
    @Log(title = "干休所信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Retired retired)
    {
        return toAjax(retiredService.updateRetired(retired));
    }

    /**
     * 删除干休所信息
     */
//    @PreAuthorize("@ss.hasPermi('system:retired:remove')")
    @Log(title = "干休所信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(retiredService.deleteRetiredByIds(ids));
    }
}
