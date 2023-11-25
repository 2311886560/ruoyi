<template>
  <div :class="className" :style="{ height: height, width: width }" />
</template>

<script>
import * as echarts from 'echarts';
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    },
    propSeriesData: {
      type: Object,
      default: {
        xAxis: [],
        data: []
      },
      require: false
    },
    interval: {
      type: String,
      default: 'auto',
      require: false
    },
    rotate: {
      type: Number,
      default: 0,
      require: false
    },
    type: {
      type: String,
      default: "default",
    },
    queryParams: {
      type: Object,
      default: {
      },
    }
  },
  data() {
    return {
      chart: null,
      barData: this.propSeriesData
    }
  },
  watch: {
    propSeriesData: function (newValue, oldValue) {
      this.barData = newValue;
      console.log(this.barData, "-------barData")
      this.initChart();
    },
    queryParams: function (newValue, oldValue) {
      this.queryParams = newValue;
    }
  },
  mounted() {
    //this.initChart();
  },
  beforeDestroy() {
    this.disposeChart()
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      console.log(this.barData, "-------barData")
      if (this.chart) {
        this.chart.setOption({
          title: {
            text: ''
          },
          dataZoom: [
            {
              // 设置滚动条的隐藏与显示
              show: false,
              // 设置滚动条类型
              type: "slider",
              // 设置背景颜色
              backgroundColor: "rgb(243,243,243)",
              // 设置选中范围的填充颜色
              fillerColor: "rgb(255,255,255)",
              // 设置边框颜色
              borderColor: "rgb(19, 63, 100)",
              // 是否显示detail，即拖拽时候显示详细数值信息
              showDetail: false,
              // 数据窗口范围的起始数值
              startValue: 0,
              // 数据窗口范围的结束数值（一页显示多少条数据）
              endValue: 10,
              // empty：当前数据窗口外的数据，被设置为空。
              // 即不会影响其他轴的数据范围
              filterMode: "empty",
              // 设置滚动条宽度，相对于盒子宽度
              width: "100%",
              // 设置滚动条高度
              height: 6,
              // 设置滚动条显示位置
              left: "center",
              // dataZoom-slider组件离容器下侧的距离
              bottom: 3,
            },
            {
              // 没有下面这块的话，只能拖动滚动条，
              // 鼠标滚轮在区域内不能控制外部滚动条
              type: "inside",
              // 滚轮是否触发缩放
              zoomOnMouseWheel: false,
              // 鼠标滚轮触发滚动
              moveOnMouseMove: true,
              moveOnMouseWheel: true,
            },
          ],
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            },
            textStyle: { color: '#ffffff' },
          },
          legend: {
            orient: 'horizontal',
            y: 'bottom'
          },
          grid: {
            top: 10,
            left: '2%',
            right: '5%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: {
            name: this.barData.xAxisName,
            type: 'category',
            axisTick: { show: false },
            data: this.barData.xAxis,
            axisLabel: {
              interval: this.interval,
              rotate: this.rotate,
              formatter: function (value) {
                let res = value;
                if (res.length > 10) {
                  res = res.substring(0, 10) + "..";
                }
                return res;
              }
            }
          },
          yAxis: {
            name: this.barData.yAxisName,
            type: 'value',
            minInterval: 1,
          },
          series: this.barData.data
        })
        // window.addEventListener('resize', () => this.chart.resize(), false)
      }

      let that = this;
      this.chart.getZr().on('click', params => {
        let pointInPixel = [params.offsetX, params.offsetY]
        if (that.chart.containPixel('grid', pointInPixel)) {
          //点击第几个柱子
          let pointInGrid = that.chart.convertFromPixel({ seriesIndex: 0 }, pointInPixel)
          // x轴数据的索引
          let xIndex = pointInGrid[0]
          // y轴数据的索引
          let yIndex = pointInGrid[1]
          if (this.$listeners.yClick) {
            this.$emit("yClick", this.barData.xAxis[xIndex])
          }
        }
      })
    },

    disposeChart: function () {
      setTimeout(() => {
        if (!this.chart) {
          return
        }
        this.chart.dispose()
        this.chart = null
      })
    },
  }
}
</script>
