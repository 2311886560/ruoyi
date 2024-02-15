<template>
  <div class="container">
    <div class="upper-container">
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="120px">
        <el-form-item label="商品" prop="goodsId" label-width="auto">
          <el-select v-model="queryParams.goodsId" placeholder="请选择商品"
                     clearable filterable>
            <el-option v-for="item in goodsInfoOptions" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时间" label-width="auto">
          <el-date-picker @change="handleQuery" v-model="fieldDate" type="monthrange" align="right" format="yyyy-MM"
            value-format="yyyy/MM/dd" unlink-panels range-separator="至" start-placeholder="开始月份" end-placeholder="结束月份">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
      <div class="chart-container">
        <el-row :gutter="20">
          <el-col :span="24">
            <el-card shadow="never" class="chart-card">
              <template #header>
                <div class="card-header">
                  销售数量(时间-销售数量)
                </div>
              </template>
              <div v-loading="loading">
                <LineChart height="300px" :propSeriesData="patrolChartDataByGoodsAmount" />
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
import {statisticsGoodsInfo, statisticsOrder} from "@/api/factory/order";

require('echarts/theme/macarons')
import BarChart from '@/views/dashboard/BarChart'
import PieChart from '@/views/dashboard/PieChart'
import LineChart from '@/views/dashboard/LineChart'
// import PieChart from '../components/PieChart'
// import BarChart from '../components/BarChart'
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {listGoodsInfo} from "@/api/factory/goodsInfo";

export default {
  naem: 'goodsOrderInfo',
  components: {
    PieChart,
    BarChart,
    LineChart,
  },
  data() {
    return {
      patrolChartDataByNumber: {
        xAxisName: '年月',
        xAxis: ['2023-1', '2023-2'],
        yAxisName: '数量'
      },
      patrolChartDataByGoodsAmount: {
        xAxis: [],
        data: [{
          name: '',
          data: []
        }]
      },
      patrolChartDataBySalesPrice: {
        xAxis: [],
        data: [{
          name: '',
          data: []
        }]
      },
      // 日期范围
      fieldDate: [],
      loading: false,
      queryParams: {
        beginTime: null,
        endTime: null,
        goodsId: null,
      },
      // 可选的商品列表
      goodsInfoOptions: {},
    }
  },
  created() {
    this.loading = true
    this.getList()
    this.getGoodsInfoOption();
  },
  methods: {
    // 查询商品列表
    getGoodsInfoOption() {
      listGoodsInfo({ pageNum: 1, pageSize: 999 }).then(response => {
        this.goodsInfoOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.name, value: item.id, ...item }
          return c;
        })
      })
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
    getList() {
      this.loading = true
      console.log("-----", this.fieldDate)
      if (this.fieldDate && this.fieldDate[0] && this.fieldDate[1]) {
        this.queryParams.beginTime = this.fieldDate[0];
        this.queryParams.endTime = this.fieldDate[1];
      } else {
        // 获取当前时间
        var currentDate = new Date();
        // 获取当前年份
        var currentYear = currentDate.getFullYear();
        // 构造当前年的第一天日期
        // var firstDayOfYear = new Date(currentYear, 0, 1);
        var dt = new Date();
        dt.setMonth(dt.getMonth() - 6);
        var firstDayOfYear = dt;
        // 构造当前年的最后一天日期
        // var lastDayOfYear = new Date(currentYear, 11, 31);
        var lastDayOfYear = currentDate;
        this.$set(this, "fieldDate", [])
        // this.fieldDate = []
        let date = []
        date[0] = firstDayOfYear.toLocaleDateString()
        date[1] = lastDayOfYear.toLocaleDateString()
        this.queryParams.beginTime = firstDayOfYear.toLocaleDateString();
        this.queryParams.endTime = lastDayOfYear.toLocaleDateString();
        this.$set(this, "fieldDate", date)
        console.log("-----", this.fieldDate)
      }
      statisticsGoodsInfo(this.queryParams).then(response => {
        this.patrolChartDataByGoodsAmount = { ...response.data.patrolChartDataByGoodsAmount };
      }).finally(() => { this.loading = false })
    },
  }
}

</script>
<style scoped lang="scss">
.a {
  color: #2b8dff;
  cursor: pointer;
}

.container {
  width: 100%;
  height: 100%;
  padding: 20px;

  .upper-container {


    .upper-form-inline {
      margin: 20px 0 12px 0;
      padding-left: 16px;
    }

  }

  .chart-container {
    .el-card {
      border: none;

      ::v-deep .el-card__header {
        border-bottom: none;
      }

      .card-header {
        border-left: 3px solid #00A8DA;
        padding-left: 12px;
        font-size: 16px;
        font-weight: 600;
      }
    }

    .patrol-echart {
      width: 100%;
      height: 300px
    }

  }

}

.patrol-input {
  float: left;
}

.chart-card {
  height: 100%;
}

.el-card {
  ::v-deep .el-card__header {
    border-bottom: none;
  }
}

.down-container {
  margin-top: 15px;

  .down-card-header {
    border-left: 3px solid #00A8DA;
    padding-left: 12px;
    font-size: 16px;
    font-weight: 600;
  }

}

.row-cell-w {
  .el-col:nth-child(1) .box-card-model {
    background: linear-gradient(358deg, #318ffd, #0c6ee2);
  }

  .el-col:nth-child(2) .box-card-model {
    background: linear-gradient(358deg, #776cff, #493afc);
  }

  .el-col:nth-child(3) .box-card-model {
    background: linear-gradient(358deg, #fbac5e, #f48d29);
  }

  .box-card-model {
    text-align: center;
    color: white;

    h2 {
      font-weight: bold;
      font-size: 24px;
    }

    span {
      font-size: 14px;
    }
  }
}
</style>
