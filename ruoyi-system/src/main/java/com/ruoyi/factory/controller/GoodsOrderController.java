package com.ruoyi.factory.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.factory.domain.vo.GoodsOrderVo;
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
import com.ruoyi.factory.domain.GoodsOrder;
import com.ruoyi.factory.service.IGoodsOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单Controller
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@RestController
@RequestMapping("/factory/order")
public class GoodsOrderController extends BaseController {
    @Resource
    private IGoodsOrderService goodsOrderService;

    /**
     * 查询商品订单列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsOrderVo goodsOrder) {
        startPage();
        List<GoodsOrderVo> list = goodsOrderService.selectGoodsOrderList(goodsOrder);
        return getDataTable(list);
    }

    /**
     * 导出商品订单列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:export')")
    @Log(title = "商品订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsOrderVo goodsOrder) {
        List<GoodsOrderVo> list = goodsOrderService.selectGoodsOrderList(goodsOrder);
        ExcelUtil<GoodsOrderVo> util = new ExcelUtil<GoodsOrderVo>(GoodsOrderVo.class);
        util.exportExcel(response, list, "商品订单数据");
    }

    /**
     * 获取商品订单详细信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(goodsOrderService.selectGoodsOrderById(id));
    }

    /**
     * 新增商品订单
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:add')")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsOrder goodsOrder) {
        return toAjax(goodsOrderService.insertGoodsOrder(goodsOrder));
    }

    /**
     * 修改商品订单
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:edit')")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsOrder goodsOrder) {
        return toAjax(goodsOrderService.updateGoodsOrder(goodsOrder));
    }

    /**
     * 删除商品订单
     */
//    @PreAuthorize("@ss.hasPermi('factory:order:remove')")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsOrderService.deleteGoodsOrderByIds(ids));
    }
}
