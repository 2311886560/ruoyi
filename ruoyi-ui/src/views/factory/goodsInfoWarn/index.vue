<template>
  <div class="app-container" style="height: 100%">
    <el-row>
      <el-col :span="16" style="padding-left: 20px;">
        <el-row>
          <div class="table_top top_border">
            <div>订单列表</div>
            <div style="color: green" @click="toGoodsOrderList">查看详情</div>
          </div>
        </el-row>
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
                 label-width="68px">
          <el-form-item label="订单编号" prop="orderCode">
            <el-input v-model="queryParams.orderCode" placeholder="请输入订单编号" maxlength="30" clearable
                      @keyup.enter.native="handleQuery"/>
          </el-form-item>
          <el-form-item label="订单标题" prop="orderTitle">
            <el-input v-model="queryParams.orderTitle" placeholder="请输入订单标题" maxlength="30" clearable
                      @keyup.enter.native="handleQuery"/>
          </el-form-item>
          <el-form-item v-if="userInfo.userType !== '21'" label="购买客户" prop="buyerUserId">
            <el-select v-model="queryParams.buyerUserId" placeholder="请选择购买客户" clearable style="width: 240px">
              <el-option v-for="item in userOptions" :key="item.value" :label="item.label"
                         :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品" prop="goodsId" label-width="auto">
            <el-select v-model="queryParams.goodsId" placeholder="请选择商品"
                       clearable filterable>
              <el-option v-for="item in goodsInfoOptions" :key="item.value" :label="item.label"
                         :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>
        <el-table v-loading="loading" :data="orderList">
          <el-table-column label="订单编号" align="center" prop="orderCode"/>
          <el-table-column label="订单标题" align="center" prop="orderTitle"/>
          <el-table-column label="购买客户" align="center" prop="buyerUserName"/>
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
          <el-table-column label="联系方式" align="center" prop="contactPhone"/>
          <el-table-column label="物流编号" align="center" prop="logisticsCode"/>
          <el-table-column label="订单状态" align="center" prop="status">
            <template slot-scope="scope">
              <dict-tag :options="dict.type.sys_goods_order_status" :value="scope.row.status"/>
            </template>
          </el-table-column>
          <el-table-column label="生产状态" align="center" prop="produceStatus">
            <template slot-scope="scope">
              <dict-tag :options="dict.type.sys_goods_order_produce_status" :value="scope.row.produceStatus"/>
            </template>
          </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum"
                    :limit.sync="queryParams.pageSize"
                    @pagination="getList"/>
      </el-col>
      <el-col :span="8" style="padding-left: 20px;">
        <el-row>
          <div class="table_top top_border">
            <div>库存预警</div>
            <div style="color: green" @click="toGoodsInfoList">查看详情</div>
          </div>
        </el-row>
        <el-row v-if="goodsInfoTotal > 0">
<!--          <div class="table_top" style="background-color: #f8f8f9; color: #515a6e; height: 40px; font-size: 13px;">-->
<!--            <div>商品</div>-->
<!--            <div>状态</div>-->
<!--          </div>-->
          <div class="table_top" v-for="item in goodsInfoList">
            <div>{{ item.name }}</div>
            <div style="color: red">
              {{ item.inventory >= item.maxInventory ? '大于最高库存量' : item.inventory <= item.minInventory ? '小于最低库存量' : '-' }}
            </div>
          </div>
        </el-row>
        <el-row v-else>
          <div style="color: deepskyblue">暂无库存预警商品</div>
        </el-row>

      </el-col>
    </el-row>
  </div>
</template>

<script>
import {listOrder, getOrder, delOrder, addOrder, updateOrder} from "@/api/factory/order";
import {addOrderMessage, listOrderMessage} from "@/api/factory/orderMessage";
import {listGoodsInfo} from "@/api/factory/goodsInfo";
import {listEnterpriseBase} from "@/api/factory/enterpriseBase";
import {listUser} from "@/api/system/user";
import {getInfo} from '@/api/login'
import {formatNumber} from "@/utils/util";

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
      messagesList: [],
      // 可选的商品列表
      goodsInfoOptions: [],
      // 用户选项
      userOptions: [],
      // 商品信息表格数据
      goodsInfoList: [],
      // 商品信息表格数据总数
      goodsInfoTotal: 0,
    };
  },
  created() {
    this.getList();
    this.getGoodsList();
    this.getGoodsInfoOption();
    this.getUserOption();
    this.getUserInfo();
  },
  methods: {
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
      })
    },
    // 查询用户列表
    getUserOption() {
      listUser({pageNum: 1, pageSize: 999, userType: '21'}).then(response => {
        this.userOptions = response.rows.map((item, index, arr) => {
          let c = {label: item.nickName, value: item.userId}
          return c;
        })
      })
    },
    // 查询商品列表
    getGoodsInfoOption() {
      listGoodsInfo({pageNum: 1, pageSize: 999}).then(response => {
        this.goodsInfoOptions = response.rows.map((item, index, arr) => {
          let c = {label: item.name, value: item.id, ...item}
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
    /** 查询商品预警列表 */
    getGoodsList() {
      listGoodsInfo({pageNum: 1, pageSize: 999, showWarn: 'true'}).then(response => {
        this.goodsInfoList = response.rows;
        this.goodsInfoTotal = response.total;
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
    toGoodsInfoList() {
      this.$router.push("/goodsInfo/goodsInfo");
    },
    toGoodsOrderList() {
      this.$router.push("/goodsOrder/goodsOrder");
    }
  }
};
</script>

<style scoped lang="scss">
.table_top {
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.top_border {
  border-bottom: 1px solid rgba(0, 0, 0, 0.51);
}

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
