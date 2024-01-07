<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from 'echarts';
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

const animationDuration = 6000

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
      // console.log(this.barData, "-------barData")
      this.initChart();
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      // console.log(this.barData, "-------barData")

      this.chart.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          top: 10,
          left: '2%',
          right: '5%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
          // name: this.barData.xAxisName,
          type: 'category',
          data: this.barData.xAxis,
          // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
          axisTick: {
            alignWithLabel: true
          }
        }],
        yAxis: [{
          name: this.barData.yAxisName,
          type: 'value',
          axisTick: {
            show: false
          }
        }],
        series: this.barData.data
        // series: [{
        //   name: 'pageA',
        //   type: 'bar',
        //   stack: 'vistors',
        //   barWidth: '60%',
        //   data: [79, 52, 200, 334, 390, 330, 220],
        //   animationDuration
        // }, {
        //   name: 'pageB',
        //   type: 'bar',
        //   stack: 'vistors',
        //   barWidth: '60%',
        //   data: [80, 52, 200, 334, 390, 330, 220],
        //   animationDuration
        // }, {
        //   name: 'pageC',
        //   type: 'bar',
        //   stack: 'vistors',
        //   barWidth: '60%',
        //   data: [30, 52, 200, 334, 390, 330, 220],
        //   animationDuration
        // }]
      })
    }
  }
}
</script>
