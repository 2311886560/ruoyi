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
import com.ruoyi.examine.domain.Hospital;
import com.ruoyi.examine.service.IHospitalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医院信息Controller
 *
 * @author ruoyi
 * @date 2024-01-13
 */
@RestController
@RequestMapping("/system/hospital")
public class HospitalController extends BaseController
{
    @Resource
    private IHospitalService hospitalService;

    /**
     * 查询医院信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:list')")
    @GetMapping("/list")
    public TableDataInfo list(Hospital hospital)
    {
        startPage();
        List<Hospital> list = hospitalService.selectHospitalList(hospital);
        return getDataTable(list);
    }

    /**
     * 导出医院信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:export')")
    @Log(title = "医院信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Hospital hospital)
    {
        List<Hospital> list = hospitalService.selectHospitalList(hospital);
        ExcelUtil<Hospital> util = new ExcelUtil<Hospital>(Hospital.class);
        util.exportExcel(response, list, "医院信息数据");
    }

    /**
     * 获取医院信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hospitalService.selectHospitalById(id));
    }

    /**
     * 新增医院信息
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:add')")
    @Log(title = "医院信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Hospital hospital)
    {
        return toAjax(hospitalService.insertHospital(hospital));
    }

    /**
     * 修改医院信息
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:edit')")
    @Log(title = "医院信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Hospital hospital)
    {
        return toAjax(hospitalService.updateHospital(hospital));
    }

    /**
     * 删除医院信息
     */
//    @PreAuthorize("@ss.hasPermi('system:hospital:remove')")
    @Log(title = "医院信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hospitalService.deleteHospitalByIds(ids));
    }
}
