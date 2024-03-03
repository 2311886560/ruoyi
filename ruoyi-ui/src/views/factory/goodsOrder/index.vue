<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单编号" prop="orderCode">
        <el-input v-model="queryParams.orderCode" placeholder="请输入订单编号" maxlength="30" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单标题" prop="orderTitle">
        <el-input v-model="queryParams.orderTitle" placeholder="请输入订单标题" maxlength="30" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择订单状态" clearable style="width: 240px">
          <el-option v-for="dict in dict.type.sys_goods_order_status" :key="dict.value" :label="dict.label"
                     :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item v-if="userInfo.userType !== '21'" label="购买客户" prop="buyerUserId">
        <el-select v-model="queryParams.buyerUserId" placeholder="请选择购买客户" clearable style="width: 240px">
          <el-option v-for="item in userOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="物流编号" prop="logisticsCode">-->
<!--        <el-input v-model="queryParams.logisticsCode" placeholder="请输入物流编号" maxlength="30" clearable @keyup.enter.native="handleQuery" />-->
<!--      </el-form-item>-->
      <el-form-item label="商品" prop="goodsId" label-width="auto">
        <el-select v-model="queryParams.goodsId" placeholder="请选择商品"
                   clearable filterable>
          <el-option v-for="item in goodsInfoOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8" v-if="userInfo.userType !== '10'">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增
        </el-button>
      </el-col>
      <!--<el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate">修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete">删除
        </el-button>
      </el-col>-->
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport">导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单编号" align="center" prop="orderCode" />
      <el-table-column label="订单标题" align="center" prop="orderTitle" />
<!--      <el-table-column label="卖方企业" align="center" prop="salerEntName" />-->
      <el-table-column label="购买客户" align="center" prop="buyerUserName" />
<!--      <el-table-column label="员工" align="center" prop="salerUserName" />-->
      <el-table-column label="订单时间" align="center" prop="orderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="截止时间" align="center" prop="confirmTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.confirmTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="联系方式" align="center" prop="contactPhone" />
      <el-table-column label="物流编号" align="center" prop="logisticsCode" />
      <el-table-column label="订单状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_goods_order_status" :value="scope.row.status" />
        </template>
      </el-table-column>
      <el-table-column label="生产状态" align="center" prop="produceStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_goods_order_produce_status" :value="scope.row.produceStatus" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-view" @click="handleDetails(scope.row)">详情
          </el-button>
          <el-button v-if="(['11', '21'].includes(userInfo.userType) > 0 && !checkUpdateInfo(scope.row)) || userInfo.userType === '00' || userInfo.userType === '10'" size="mini" type="text" icon="el-icon-edit"
            @click="handleUpdate(scope.row)">修改
          </el-button>
          <el-button v-if="userInfo.userType !== '10' && !checkUpdateInfo(scope.row)" size="mini" type="text" icon="el-icon-delete"
            @click="handleDelete(scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改商品订单主对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单状态" prop="status">
          <el-select :disabled="openType === 'details' || ['11', '21'].includes(userInfo.userType) > 0" v-model="form.status" placeholder="请选择订单状态">
            <el-option v-for="item in dict.type.sys_goods_order_status" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="生产状态" prop="produceStatus" v-if="form.status === '1'">
          <el-select :disabled="openType === 'details'" v-model="form.produceStatus" placeholder="请选择生产状态">
            <el-option v-for="item in dict.type.sys_goods_order_produce_status" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="订单编号" prop="orderCode">
          <el-input :disabled="openType === 'details' || checkUpdateInfo(form)" v-model="form.orderCode" placeholder="请输入订单编号" maxlength="30" />
        </el-form-item>
        <el-form-item label="订单标题" prop="orderTitle">
          <el-input :disabled="openType === 'details' || checkUpdateInfo(form)" v-model="form.orderTitle" placeholder="请输入订单标题" maxlength="30" />
        </el-form-item>
<!--        <el-form-item label="订单时间" prop="orderTime">-->
<!--          <el-date-picker :disabled="openType === 'details'" clearable v-model="form.orderTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择订单时间">-->
<!--          </el-date-picker>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="卖方企业" prop="salerEntId">-->
<!--          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.salerEntId" placeholder="请选择卖方企业">-->
<!--            <el-option v-for="item in entOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item v-if="userInfo.userType !== '21'" label="购买客户" prop="buyerUserId">
          <el-select :disabled="openType === 'details' || checkUpdateInfo(form)" style="width: 100%;" v-model="form.buyerUserId" placeholder="请选择购买客户">
            <el-option v-for="item in userOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="截止时间" prop="confirmTime">
          <el-date-picker :disabled="openType === 'details' || checkUpdateInfo(form)" clearable v-model="form.confirmTime" type="date" value-format="yyyy-MM-dd"
            placeholder="请选择截止时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="交货时间" prop="deliveryTime">
          <el-date-picker :disabled="openType === 'details' || checkUpdateInfo(form)" clearable v-model="form.deliveryTime" type="date" value-format="yyyy-MM-dd"
                          placeholder="请选择交货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="交货地址" prop="deliveryAddress">
          <el-input :disabled="openType === 'details' || checkUpdateInfo(form)" v-model="form.deliveryAddress" placeholder="请输入交货地址" maxlength="50" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactPhone">
          <el-input :disabled="openType === 'details' || checkUpdateInfo(form)" v-model="form.contactPhone" placeholder="请输入联系方式" maxlength="30" />
        </el-form-item>
        <el-form-item label="物流编号" prop="logisticsCode" v-if="form.status === '1' && form.produceStatus === '5'">
          <el-input :disabled="openType === 'details'" v-model="form.logisticsCode" placeholder="请输入物流编号" maxlength="30" />
        </el-form-item>
        <el-form-item label="订单发票" prop="orderInvoice" v-if="form.status === '1' && form.produceStatus === '5'">
          <image-upload :disabled="openType === 'details'" v-model="form.orderInvoice" :limit="3" />
        </el-form-item>
        <el-form-item label="付款凭证" prop="paymentVoucher" v-if="form.status === '1' && form.produceStatus === '5'">
          <image-upload :disabled="openType === 'details'" v-model="form.paymentVoucher" :limit="3" />
        </el-form-item>
        <el-divider content-position="center">商品信息</el-divider>
        <el-row :gutter="10" class="mb8" v-if="openType !== 'details' && !checkUpdateInfo(form)">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddGoodsOrderSub">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteGoodsOrderSub">删除
            </el-button>
          </el-col>
        </el-row>
        <el-table :data="goodsOrderSubList" :row-class-name="rowGoodsOrderSubIndex"
          @selection-change="handleGoodsOrderSubSelectionChange" ref="goodsOrderSub">
          <el-table-column v-if="openType !== 'details' && !checkUpdateInfo(form)" type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50" />
          <el-table-column label="商品">
            <template slot-scope="scope">
              <el-select :disabled="openType === 'details' || checkUpdateInfo(form)" style="width: 100%;" v-model="scope.row.goodsId" placeholder="请选择商品"
                         clearable filterable @change="(e) => onChangeGoods(e, scope.row)">
                <el-option v-for="item in goodsInfoOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="数量" prop="orderAmount" width="150">
            <template slot-scope="scope">
              <el-input :disabled="openType === 'details' || checkUpdateInfo(form)" v-model="scope.row.orderAmount" @input="onChangeInput(scope.row, 'orderAmount')" maxlength="8" placeholder="请输入数量" />
            </template>
          </el-table-column>
          <el-table-column label="销售价" prop="salesPrice" width="150">
            <template slot-scope="scope">
              <span>{{scope.row.salesPrice}}</span>
<!--              <el-input :disabled="openType === 'details'" v-model="scope.row.salesPrice" @input="onChangeInput(scope.row, 'salesPrice')" placeholder="请输入销售价" />-->
            </template>
          </el-table-column>
          <el-table-column label="总价" prop="totalPrice" width="150">
            <template slot-scope="scope">
              <span>{{scope.row.totalPrice}}</span>
<!--              <el-input :disabled="openType === 'details'" v-model="scope.row.totalPrice" @input="onChangeInput(scope.row, 'totalPrice')" placeholder="请输入总价" />-->
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="openType !== 'details'">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/factory/order";
import { listGoodsInfo } from "@/api/factory/goodsInfo";
import { listEnterpriseBase } from "@/api/factory/enterpriseBase";
import { listUser } from "@/api/system/user";
import { getInfo } from '@/api/login'
import { formatNumber } from "@/utils/util";

export default {
  name: "Order",
  dicts: ['sys_goods_order_status', 'sys_goods_order_produce_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 详细表选中数据
      checkedGoodsOrderSub: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 商品订单主表格数据
      orderList: [],
      // 商品订单详细表格数据
      goodsOrderSubList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示弹出层
      openType: 'details',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderCode: null,
        orderTitle: null,
        salerEntId: null,
        buyerUserId: null,
        salerUserId: null,
        orderTime: null,
        confirmTime: null,
        logisticsCode: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "订单状态不能为空", trigger: "change" }
        ],
        orderCode: [
          { required: true, message: "订单编号不能为空", trigger: "change" }
        ],
        orderTitle: [
          { required: true, message: "订单标题不能为空", trigger: "change" }
        ],
        orderTime: [
          { required: true, message: "订单时间不能为空", trigger: "change" }
        ],
        buyerUserId: [
          { required: true, message: "购买客户不能为空", trigger: "change" }
        ],
        confirmTime: [
          { required: true, message: "截止时间不能为空", trigger: "change" }
        ],
        logisticsCode: [
          { required: true, message: "物流编号不能为空", trigger: "change" }
        ],
        deliveryAddress: [
          { required: true, message: "交货地址不能为空", trigger: "change" }
        ],
        contactPhone: [
          { required: true, message: "联系方式不能为空", trigger: "change" }
        ],
      },
      // 可选的商品列表
      goodsInfoOptions: [],
      // 企业选项
      entOptions: [],
      // 用户选项
      userOptions: [],
      // 用户信息
      userInfo: {
        userType: '00'
      },
    };
  },
  created() {
    this.getList();
    this.getGoodsInfoOption();
    this.getEntOption();
    this.getUserOption();
    this.getUserInfo();
  },
  methods: {
    checkUpdateInfo(row) {
      if (row.status === 0 || row.status === '0') {
        return false
      }
      return true
    },
    onChangeGoods(e, row){
      let goods = this.goodsInfoOptions.find((item) => item.value === e)
      row.orderAmount = 0
      row.salesPrice = goods.salesPrice
      row.totalPrice = 0
    },
    /** 限制输入框输入两位小数 */
    onChangeInput(row, name){
      row[name] = formatNumber(row[name]);
      if(name === 'orderAmount') {
        let unitPrice = row.salesPrice;
        let number = row.orderAmount;
        if (unitPrice == null || isNaN(unitPrice)) {
          unitPrice = 0;
        }
        if (number == null || isNaN(number)|| !number) {
          number = 0;
        }
        let rowTotal = (unitPrice * number).toFixed(2);
        row.totalPrice = rowTotal;
      }
    },
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
      })
    },
    // 查询用户列表
    getUserOption() {
      listUser({ pageNum: 1, pageSize: 999, userType: '21' }).then(response => {
        this.userOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.nickName, value: item.userId }
          return c;
        })
      })
    },
    // 查询企业列表
    getEntOption() {
      listEnterpriseBase({ pageNum: 1, pageSize: 999 }).then(response => {
        this.entOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.entName, value: item.id }
          return c;
        })
      })
    },
    // 查询商品列表
    getGoodsInfoOption() {
      listGoodsInfo({ pageNum: 1, pageSize: 999 }).then(response => {
        this.goodsInfoOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.name, value: item.id, ...item }
          return c;
        })
      })
    },
    /** 查询商品订单主列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        orderCode: null,
        orderTitle: null,
        salerEntId: null,
        buyerUserId: null,
        salerUserId: null,
        orderTime: null,
        confirmTime: null,
        logisticsCode: null,
        status: '0',
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        produceStatus: null,
        deliveryTime: null,
        deliveryAddress: null,
        contactPhone: null,
        orderInvoice: null,
        paymentVoucher: null
      };
      this.goodsOrderSubList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.openType = 'add';
      this.title = "添加商品订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.goodsOrderSubList = response.data.goodsOrderSubList;
        this.open = true;
        this.openType = 'update';
        this.title = "修改商品订单";
      });
    },
    /** 详情按钮操作 */
    handleDetails(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.goodsOrderSubList = response.data.goodsOrderSubList;
        this.open = true;
        this.openType = 'details';
        this.title = "商品订单信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      if (!this.goodsOrderSubList || this.goodsOrderSubList.length < 1){
        this.$modal.msgError("请选择商品");
      }
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.goodsOrderSubList = this.goodsOrderSubList;
          if (this.form.id != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商品订单为"' + ids + '"的数据项？').then(function () {
        return delOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 商品订单详细序号 */
    rowGoodsOrderSubIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 商品订单详细添加按钮操作 */
    handleAddGoodsOrderSub() {
      let obj = {};
      obj.goodsId = "";
      obj.orderAmount = "";
      obj.salesPrice = "";
      obj.totalPrice = "";
      obj.status = "";
      this.goodsOrderSubList.push(obj);
    },
    /** 商品订单详细删除按钮操作 */
    handleDeleteGoodsOrderSub() {
      if (this.checkedGoodsOrderSub.length == 0) {
        this.$modal.msgError("请先选择要删除的商品订单详细数据");
      } else {
        const goodsOrderSubList = this.goodsOrderSubList;
        const checkedGoodsOrderSub = this.checkedGoodsOrderSub;
        this.goodsOrderSubList = goodsOrderSubList.filter(function (item) {
          return checkedGoodsOrderSub.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleGoodsOrderSubSelectionChange(selection) {
      this.checkedGoodsOrderSub = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('factory/order/export', {
        ...this.queryParams
      }, `订单列表_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
