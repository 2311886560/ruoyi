<template>
  <el-dialog :title="title" :visible.sync="visible" width="34%" :close-on-click-modal="false">
    <slot name="formContent"></slot>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取 消</el-button>
      <el-button type="primary" @click="onSubmit()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "index",
  props:{
    title:{
      type: String,
      default: '提示'
    },
    status:{
      type: String,
      default: ''
    }
  },
  data(){
    return{
      visible: false,
    }
  },
  methods:{
    onSubmit(){
      this.$emit("onSubmit",this.status);
    }
  }
}
</script>

<style scoped>

</style>
