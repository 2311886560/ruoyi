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
    propSeriesData: {
      type: Object,
      default: {
        indicator: [],
        data: []
      },
      require: false
    },
    propRadarName: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      chart: null,
      radarData: this.propSeriesData,
      radarName: this.propRadarName
    }
  },
  watch:{
    propSeriesData:function(newValue,oldValue){
      this.radarData = newValue;
      console.log(this.radarData,this.radarName)
      this.initChart();
    },
    // propRadarName:function(newValue,oldValue){
    //   this.radarName = newValue;
    //   console.log(this.radarData,this.radarName)
    //   this.initChart();
    // },
  },
  mounted() {
    /*this.initChart();*/
  },
  beforeDestroy() {
    this.disposeChart()
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$el, 'macarons')
      if (this.chart) {
        let radarIndex = -1
        this.chart.setOption({
          title: {
            text: ''
          },
          legend: {
            data: [this.radarName],
            y: 'bottom'
          },
          radar: {
            // shape: 'circle',
            indicator: this.radarData.indicator,
            radius: 100,
            name: {
              rich: {
                b: {
                  color: '#fff',
                  align: 'center',
                  backgroundColor: '#666',
                  padding: 2,
                  borderRadius: 4
                }
              },
              formatter: (a, b) => {
                radarIndex++
                return `${a} \n ${this.radarData.data[radarIndex]}`
              }
            }
          },
          series: [
            {
              name: this.radarName,
              type: 'radar',
              itemStyle: { // 折线拐点标志的样式。
                normal: { // 普通状态时的样式
                  lineStyle: {
                    width: 2
                  },
                  opacity: 0.9
                }
              },
              data: [{
                value: this.radarData.data,
                name: this.radarName,
                areaStyle: {
                  normal: {
                    color: '#42CCCE'
                  }
                }
              }]
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
