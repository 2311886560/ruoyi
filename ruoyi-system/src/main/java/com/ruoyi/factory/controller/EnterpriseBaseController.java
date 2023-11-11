package com.ruoyi.factory.controller;

import java.util.List;
import javax.annotation.Resource;
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
import com.ruoyi.factory.domain.EnterpriseBase;
import com.ruoyi.factory.service.IEnterpriseBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工厂基本信息Controller
 *
 * @author ruoyi
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/factory/enterpriseBase")
public class EnterpriseBaseController extends BaseController
{
    @Resource
    private IEnterpriseBaseService enterpriseBaseService;

    /**
     * 查询工厂基本信息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:list')")
    @GetMapping("/list")
    public TableDataInfo list(EnterpriseBase enterpriseBase)
    {
        startPage();
        List<EnterpriseBase> list = enterpriseBaseService.selectEnterpriseBaseList(enterpriseBase);
        return getDataTable(list);
    }

    /**
     * 导出工厂基本信息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:export')")
    @Log(title = "工厂基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EnterpriseBase enterpriseBase)
    {
        List<EnterpriseBase> list = enterpriseBaseService.selectEnterpriseBaseList(enterpriseBase);
        ExcelUtil<EnterpriseBase> util = new ExcelUtil<EnterpriseBase>(EnterpriseBase.class);
        util.exportExcel(response, list, "工厂基本信息数据");
    }

    /**
     * 获取工厂基本信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(enterpriseBaseService.selectEnterpriseBaseById(id));
    }

    /**
     * 新增工厂基本信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:add')")
    @Log(title = "工厂基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EnterpriseBase enterpriseBase)
    {
        return toAjax(enterpriseBaseService.insertEnterpriseBase(enterpriseBase));
    }

    /**
     * 修改工厂基本信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:edit')")
    @Log(title = "工厂基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EnterpriseBase enterpriseBase)
    {
        return toAjax(enterpriseBaseService.updateEnterpriseBase(enterpriseBase));
    }

    /**
     * 删除工厂基本信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:enterpriseBase:remove')")
    @Log(title = "工厂基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(enterpriseBaseService.deleteEnterpriseBaseByIds(ids));
    }
}
