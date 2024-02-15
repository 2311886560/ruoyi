<template>
  <div :class="className" :style="{height:height,width:width}" />
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
      default: '350px'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    propSeriesData: {
      type: Object,
      default: {
        xAxis: [],
        data: [{
          name: '',
          data: []
        }]
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
      this.setOptions()
    },
    setOptions({ expectedData, actualData } = {}) {
      // 先清空
      this.chart.clear()

      let seriesName = ""
      let series = []
      actualData = this.barData.data[0].data
      if (this.barData.data){
        for (let i = 0; i < this.barData.data.length; i++) {
          console.log("------------this.barData.data[i]",this.barData.data[i])
          series.push({
            name: this.barData.data[i].name,
            type: 'line',
            stack: 'Total',
            data: this.barData.data[i].data
          })
        }
      }
      console.log("------------111",series)
      this.chart.setOption({
        xAxis: {
          data: this.barData.xAxis,
          // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
          boundaryGap: false,
          axisTick: {
            show: false
          }
        },
        grid: {
          left: 10,
          right: 30,
          bottom: 20,
          top: 30,
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          padding: [5, 10]
        },
        yAxis: {
          axisTick: {
            show: false
          }
        },
        legend: {
          data: ['expected', 'actual']
        },
        series: series,
        // series: this.barData.data,
        // series: [
        // {
        //   name: seriesName,
        //   smooth: true,
        //   type: 'line',
        //   itemStyle: {
        //     normal: {
        //       color: '#3888fa',
        //       lineStyle: {
        //         color: '#3888fa',
        //         width: 2
        //       },
        //       areaStyle: {
        //         color: '#f3f8ff'
        //       }
        //     }
        //   },
        //   data: actualData,
        //   animationDuration: 2800,
        //   animationEasing: 'quadraticOut'
        // }]
      })
    }
  }
}
</script>
