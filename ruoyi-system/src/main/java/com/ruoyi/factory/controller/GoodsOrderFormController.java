package com.ruoyi.factory.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.factory.domain.vo.GoodsOrderFormVo;
import com.ruoyi.factory.service.IGoodsOrderFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品订单财务报表Controller
 *
 * @author ruoyi
 * @date 2023-11-11
 */
@RestController
@RequestMapping("/factory/orderForm")
public class GoodsOrderFormController extends BaseController {
    @Resource
    private IGoodsOrderFormService goodsOrderFormService;

    /**
     * 查询商品订单财务报表列表
     */
    @GetMapping("/list")
    public TableDataInfo list(GoodsOrderFormVo goodsOrderFormVo) {
        startPage();
        List<GoodsOrderFormVo> list = goodsOrderFormService.selectGoodsOrderFormList(goodsOrderFormVo);
        return getDataTable(list);
    }

    /**
     * 查询商品订单财务报表列表
     */
    @GetMapping("/subList")
    public TableDataInfo subList(GoodsOrderFormVo goodsOrderFormVo) {
        startPage();
        List<GoodsOrderFormVo> list = goodsOrderFormService.selectGoodsOrderSubFormList(goodsOrderFormVo);
        return getDataTable(list);
    }

    /**
     * 导出商品订单财务报表列表
     */
    @Log(title = "财务报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsOrderFormVo goodsOrder) {
        List<GoodsOrderFormVo> list = goodsOrderFormService.selectGoodsOrderFormList(goodsOrder);
        ExcelUtil<GoodsOrderFormVo> util = new ExcelUtil<GoodsOrderFormVo>(GoodsOrderFormVo.class);
        util.exportExcel(response, list, "财务报表数据");
    }

    /**
     * 统计商品订单
     */
    @GetMapping("/statisticsOrder")
    public AjaxResult statisticsOrder(GoodsOrderFormVo goodsOrderFormVo) {
        JSONObject jsonObject = goodsOrderFormService.statisticsOrder(goodsOrderFormVo);
        return success(jsonObject);
    }
}
