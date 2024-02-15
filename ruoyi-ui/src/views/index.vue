<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px; width: 100%">
        <el-card class="box-card" style="width: 100%">
          <div slot="header" class="clearfix">
            <h2>南宁订单工厂管理系统</h2>
          </div>
          <p>
            当前版本: <b>v{{ version }}</b>
          </p>
          <p>
            <i class="el-icon-s-custom"></i>当前登录用户: <b>{{ userInfo.nickName }}</b>， 您好，欢迎光临
          </p>
        </el-card>
        <el-card class="box-card" style="width: 100%; margin-top: 20px">
          <div slot="header" class="clearfix">
            <h2>系统基本信息</h2>
          </div>
          <p>
            <span>欢迎您使用---南宁订单工厂管理系统</span>
          </p>
          <p>
            <span>在使用过程中，欢迎您提出各种宝贵的意见和建议。</span>
          </p>
          <p>
            <span>联系电话：1893499999</span>
          </p>
          <p>
            <span>电子邮箱：1893499999@qq.com</span>
          </p>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {getInfo} from "@/api/login";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.6",
      // 用户信息
      userInfo: {
        userType: '00'
      },
    };
  },
  created() {
    this.getUserInfo();
  },
  methods: {
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
      })
    },
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;
    font-size: 24px;
    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

