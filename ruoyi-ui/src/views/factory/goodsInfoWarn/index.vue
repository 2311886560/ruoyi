<template>
  <div class="app-container" style="height: 100%">
    <el-row :gutter="20">
      <el-col :span="18" style="padding-left: 20px;">
        <el-table v-loading="loading" :data="orderList">
          <el-table-column label="订单编号" align="center" prop="orderCode" />
          <el-table-column label="订单标题" align="center" prop="orderTitle" />
          <el-table-column label="购买客户" align="center" prop="buyerUserName" />
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
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                    @pagination="getList" />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/factory/order";
import {addOrderMessage, listOrderMessage} from "@/api/factory/orderMessage";
import { listGoodsInfo } from "@/api/factory/goodsInfo";
import { listEnterpriseBase } from "@/api/factory/enterpriseBase";
import { listUser } from "@/api/system/user";
import { getInfo } from '@/api/login'
import { formatNumber } from "@/utils/util";

export default {
  name: "goodsInfoWarn",
  dicts: ['sys_goods_order_status', 'sys_goods_order_produce_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
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
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示
      openMessage: false,
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
        // 查询待审核
        status: 0,
      },
      // 表单参数
      form: {},
      // 表单参数
      formMessage: {},
      // 表单校验
      rules: {},
      // 用户信息
      userInfo: {
        userType: '00'
      },
      messagesList: []
    };
  },
  created() {
    this.getList();
    this.getUserInfo();
  },
  methods: {
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
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
  }
};
</script>

<style scoped lang="scss">
.chat-scroller {
  width: 100%;
  height: 400px;
  border: 1px solid #ccc;
  overflow-y: auto;
}

.chat-container {
  display: flex;
  flex-direction: column;
}

.bubble {
  margin: 5px;
  padding: 10px;
  border-radius: 5px;
  background-color: #f1f1f1;
}
</style>
