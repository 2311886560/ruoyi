<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="120px">
      <el-form-item label="商品" prop="orderCode" label-width="auto">
        <el-select v-model="queryParams.goodsId" placeholder="请选择商品"
                   clearable filterable>
          <el-option v-for="item in goodsInfoOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="时间" label-width="auto">
        <el-date-picker @change="handleQuery" v-model="fieldDate" type="monthrange" align="right" format="yyyy-MM"
          value-format="yyyy-MM-dd" unlink-panels range-separator="至" start-placeholder="开始月份" end-placeholder="结束月份">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8" v-if="userInfo.userType !== '21'">
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderFormList" @selection-change="handleSelectionChange">
      <!--      <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column label="订单时间" align="center" prop="orderTime" />
      <el-table-column label="成本" align="center" prop="orderCodeTotal" />
      <el-table-column label="利润" align="center" prop="profitPriceTotal" />
      <el-table-column label="销售价" align="center" prop="salesPriceTotal" />
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单状态">
          <el-select :disabled="openType === 'details'" v-model="form.status" placeholder="请选择订单状态">
            <el-option v-for="item in dict.type.sys_goods_order_status" :key="item.value" :label="item.label"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="订单编号" prop="orderCode">
          <el-input :disabled="openType === 'details'" v-model="form.orderCode" placeholder="请输入订单编号" maxlength="30" />
        </el-form-item>
        <el-form-item label="订单标题" prop="orderTitle">
          <el-input :disabled="openType === 'details'" v-model="form.orderTitle" placeholder="请输入订单标题" maxlength="30" />
        </el-form-item>
        <el-form-item label="订单时间" prop="orderTime">
          <el-date-picker :disabled="openType === 'details'" clearable v-model="form.orderTime" type="date"
            value-format="yyyy-MM-dd" placeholder="请选择订单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="卖方企业" prop="salerEntId">
          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.salerEntId"
            placeholder="请选择卖方企业">
            <el-option v-for="item in entOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购买客户" prop="buyerUserId">
          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.buyerUserId"
            placeholder="请选择购买客户">
            <el-option v-for="item in userOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="确认时间" prop="confirmTime">
          <el-date-picker :disabled="openType === 'details'" clearable v-model="form.confirmTime" type="date"
            value-format="yyyy-MM-dd" placeholder="请选择确认时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="物流编号" prop="logisticsCode">
          <el-input :disabled="openType === 'details'" v-model="form.logisticsCode" placeholder="请输入物流编号"
            maxlength="30" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="openType !== 'details'">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrderForm, getOrder } from "@/api/factory/order";
import { listEnterpriseBase } from "@/api/factory/enterpriseBase";
import { listUser } from "@/api/system/user";
import { getInfo } from '@/api/login'
import { formatNumber } from "@/utils/util";
import {listGoodsInfo} from "@/api/factory/goodsInfo";

export default {
  name: "OrderForm",
  dicts: ['sys_goods_order_status'],
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
      // 表格数据
      orderFormList: [],
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
        goodsId: null,
      },
      // 时间段
      fieldDate: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      // 企业选项
      entOptions: [],
      // 用户选项
      userOptions: [],
      // 用户信息
      userInfo: {
        userType: '00'
      },
      // 可选的商品列表
      goodsInfoOptions: {},
    };
  },
  created() {
    this.getList();
    this.getEntOption();
    this.getUserOption();
    this.getGoodsInfoOption();
    this.getUserInfo();
  },
  methods: {
    /** 限制输入框输入两位小数 */
    onChangeInput(form, name) {
      form[name] = formatNumber(form[name]);
    },
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
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
    /** 查询商品订单主列表 */
    getList() {
      this.loading = true;
      if (this.fieldDate && this.fieldDate[0] && this.fieldDate[1]) {
        this.queryParams.beginTime = this.fieldDate[0];
        this.queryParams.endTime = this.fieldDate[1];
      } else {
        // 获取当前时间
        var currentDate = new Date();
        // 获取当前年份
        var currentYear = currentDate.getFullYear();
        // 构造当前年的第一天日期
        var firstDayOfYear = new Date(currentYear, 0, 1);
        // 构造当前年的最后一天日期
        var lastDayOfYear = new Date(currentYear, 11, 31);
        this.$set(this, "fieldDate", [])
        // this.fieldDate = []
        this.fieldDate[0] = firstDayOfYear.toLocaleDateString()
        this.fieldDate[1] = lastDayOfYear.toLocaleDateString()
        this.queryParams.beginTime = firstDayOfYear.toLocaleDateString();
        this.queryParams.endTime = lastDayOfYear.toLocaleDateString();
      }
      this.$set(this, "fieldDate", this.fieldDate)

      listOrderForm(this.queryParams).then(response => {
        this.orderFormList = response.rows;
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
        status: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.fieldDate = [];
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
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
    /** 复选框选中数据 */
    handleGoodsOrderSubSelectionChange(selection) {
      this.checkedGoodsOrderSub = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('factory/orderForm/export', {
        ...this.queryParams
      }, `财务报表_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
