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
    scroll: {
      type: String,
      default: ''
    },
    propSeriesData: {
      type: Array,
      default: () => [0],
      require: false
    },
    propRadiusValue: {
      default: '65%',
    },
    propRadiusCenter:{
      type: Array,
      default: ['30%', '50%'],
      require: false
    },
    propRadiusLine:{
      type: Boolean,
      default: false,
    }
  },
  data() {
    return {
      chart: null,
      seriesData: this.propSeriesData,
      radiusValue: this.propRadiusValue,
    }
  },
  watch:{
    propSeriesData:function(newValue,oldValue){
      this.seriesData = newValue;
      this.initChart();
    }
    },
  mounted() {
    this.$parent
    debugger
    console.log(this.seriesData)
  },
  beforeDestroy() {
    this.disposeChart()
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$el, 'macarons')
      let right=''
      let bottom=''
      let orient=''
      if (this.propRadiusLine){
        bottom='bottom'
        orient='horizontal'
      }else {
        right='2%'
        orient='vertical'
      }
      if (this.chart) {
        this.chart.setOption({
          tooltip: {
            trigger: 'item',
            textStyle: { //图例文字的样式
              color: '#ffffff'
            }
          },
          legend: {
            type: this.scroll, // 设置为滚动类型，默认不滚动
            left: 'right',
            icon: 'circle',
            y: 'bottom',
            right: right,
            bottom: bottom,
            orient: orient,
            textStyle: { //图例文字的样式
              color: '#000000',
              fontSize: 11
            }
          },
          series: [
            {
              type: 'pie',
              // radius: '50%',
              // radius: ['45%', '75%'],
              center: this.propRadiusCenter,
              radius: this.radiusValue,
              top: '-15%',
              label: {
                normal: {
                  formatter: '{b} {d}%'
                  // formatter: '{b} \n {d}%'
                }
              },
              // 图形外文字线
              labelLine: {
                show: true,
                length: 6
              },
              data: this.seriesData || [],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
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
    }
  }
}
</script>
