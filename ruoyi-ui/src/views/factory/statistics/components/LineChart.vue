<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
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
    propLineData: {
      type: Object,
      default: {
        xAxisData: [],
        data: []
      },
      require: false
    },
    smooth:{
      type: Boolean,
      default: true
    },
    scroll:{
      type: String,
      default: ''
    }
  },
  data() {
    return {
      chart: null,
      lineData: this.propLineData
    }
  },
  watch:{
    propLineData:function(newValue,oldValue){
      this.lineData = newValue;
      this.initChart();
    }},
  mounted() {

  },
  beforeDestroy() {
    this.disposeChart()
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$el, 'macarons')
      if (this.chart) {
        let series = []
        let selected = {}
        for (let i = 0; i < this.lineData.lineLegendName.length; i++) {
          series.push({
            name: this.lineData.lineLegendName[i] || '',
            data: this.lineData.data[i],
            type: 'line',
            smooth: true,
            itemStyle: {
              normal: {
                label: { show: true }
              }
            }
          })
          // if(i === 0){
            selected[this.lineData.lineLegendName[i]] = true
          // }else{
          //   selected[this.lineData.lineLegendName[i]] = false
          // }
        }
        //重新渲染
        this.chart.clear();
        this.chart.setOption({
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            type: this.scroll, // 设置为滚动类型，默认不滚动
            itemHeight: 12, // 图例标记的高度
            right: 15,				// 图例位置
            bottom: 8,
            itemWidth: 10,
            itemGap: 20,
            data: this.lineData.lineLegendName,
            selected: selected,
          },
          grid: {
            left: '50px',
            right: '50px',
            containLabel: true
          },
          xAxis: {
            name: this.lineData.xAxisName,
            type: 'category',
            data: this.lineData.xAxisData,
            axisTick: {
              show: false
            }
          },
          yAxis: {
            name: this.lineData.yAxisName,
            type: 'value',
            axisTick: {
              show: false
            }
          },
          series: series
          // series: [
          //   {
          //     name: this.lineData.lineLegendName[0] || '',
          //     data: this.lineData.data[0],
          //     type: 'line',
          //     smooth: this.smooth,
          //     itemStyle: {
          //       normal: {
          //         label: { show: true }
          //       }
          //     }
          //   },
          //   {
          //     name: this.lineData.lineLegendName[1] || '',
          //     type: 'line',
          //     smooth: this.smooth,
          //     data: this.lineData.data[1],
          //     itemStyle: {
          //       normal: {
          //         label: { show: true }
          //       }
          //     }
          //   }
          // ]
        })
        // window.addEventListener('resize', () => this.chart.resize(), false)
      }
    },

    disposeChart: function() {
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
