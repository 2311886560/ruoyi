package com.ruoyi.factory.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.factory.domain.vo.GoodsInfoVo;
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
import com.ruoyi.factory.domain.GoodsInfo;
import com.ruoyi.factory.service.IGoodsInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品信息Controller
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@RestController
@RequestMapping("/factory/goodsInfo")
public class GoodsInfoController extends BaseController
{
    @Resource
    private IGoodsInfoService goodsInfoService;

    /**
     * 查询商品信息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsInfo goodsInfo)
    {
        startPage();
        List<GoodsInfoVo> list = goodsInfoService.selectGoodsInfoList(goodsInfo);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsInfo goodsInfo)
    {
        List<GoodsInfoVo> list = goodsInfoService.selectGoodsInfoList(goodsInfo);
        ExcelUtil<GoodsInfoVo> util = new ExcelUtil<GoodsInfoVo>(GoodsInfoVo.class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(goodsInfoService.selectGoodsInfoById(id));
    }

    /**
     * 新增商品信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsInfo goodsInfo)
    {
        return toAjax(goodsInfoService.insertGoodsInfo(goodsInfo));
    }

    /**
     * 修改商品信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsInfo goodsInfo)
    {
        return toAjax(goodsInfoService.updateGoodsInfo(goodsInfo));
    }

    /**
     * 删除商品信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:goodsInfo:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsInfoService.deleteGoodsInfoByIds(ids));
    }
}
