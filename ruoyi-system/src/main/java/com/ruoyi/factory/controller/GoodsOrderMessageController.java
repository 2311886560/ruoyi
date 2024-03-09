package com.ruoyi.factory.controller;

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
import com.ruoyi.factory.domain.GoodsOrderMessage;
import com.ruoyi.factory.service.IGoodsOrderMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单消息Controller
 *
 * @author ruoyi
 * @date 2024-03-09
 */
@RestController
@RequestMapping("/factory/orderMessage")
public class GoodsOrderMessageController extends BaseController {
    @Autowired
    private IGoodsOrderMessageService goodsOrderMessageService;

    /**
     * 查询商品订单消息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsOrderMessage goodsOrderMessage) {
        startPage();
        List<GoodsOrderMessage> list = goodsOrderMessageService.selectGoodsOrderMessageList(goodsOrderMessage);
        return getDataTable(list);
    }

    /**
     * 导出商品订单消息列表
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:export')")
    @Log(title = "商品订单消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsOrderMessage goodsOrderMessage) {
        List<GoodsOrderMessage> list = goodsOrderMessageService.selectGoodsOrderMessageList(goodsOrderMessage);
        ExcelUtil<GoodsOrderMessage> util = new ExcelUtil<GoodsOrderMessage>(GoodsOrderMessage.class);
        util.exportExcel(response, list, "商品订单消息数据");
    }

    /**
     * 获取商品订单消息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(goodsOrderMessageService.selectGoodsOrderMessageById(id));
    }

    /**
     * 新增商品订单消息
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:add')")
    @Log(title = "商品订单消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsOrderMessage goodsOrderMessage) {
        return toAjax(goodsOrderMessageService.insertGoodsOrderMessage(goodsOrderMessage));
    }

    /**
     * 修改商品订单消息
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:edit')")
    @Log(title = "商品订单消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsOrderMessage goodsOrderMessage) {
        return toAjax(goodsOrderMessageService.updateGoodsOrderMessage(goodsOrderMessage));
    }

    /**
     * 删除商品订单消息
     */
//    @PreAuthorize("@ss.hasPermi('factory:orderMessage:remove')")
    @Log(title = "商品订单消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsOrderMessageService.deleteGoodsOrderMessageByIds(ids));
    }
}
