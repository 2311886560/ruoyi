<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工厂编号" prop="entCode">
        <el-input v-model="queryParams.entCode" placeholder="请输入工厂编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="统一信用代码" prop="creditCode">
        <el-input v-model="queryParams.creditCode" placeholder="请输入统一信用代码" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="联系人" prop="linkerMan">
        <el-input v-model="queryParams.linkerMan" placeholder="请输入联系人" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="联系电话" prop="linkerPhone">
        <el-input v-model="queryParams.linkerPhone" placeholder="请输入联系电话" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single"
          @click="handleUpdate">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple"
          @click="handleDelete">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="enterpriseBaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工厂编号" align="center" prop="entCode" />
      <el-table-column label="统一信用代码" align="center" prop="creditCode" />
      <el-table-column label="工厂名称" align="center" prop="entName" />
      <el-table-column label="法人" align="center" prop="legalPerson" />
      <el-table-column label="法人手机号" align="center" prop="legalPhone" />
      <el-table-column label="联系人" align="center" prop="linkerMan" />
      <el-table-column label="联系电话" align="center" prop="linkerPhone" />
      <el-table-column label="单位联系电话" align="center" prop="workPhone" />
      <el-table-column label="详细地址" align="center" prop="entAddress" />
      <el-table-column label="营业执照号" align="center" prop="license" />
      <el-table-column label="营业执照" align="center" prop="licensePic" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.licensePic" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="经营范围" align="center" prop="busScope" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改工厂基本信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="工厂编号" prop="entCode">
          <el-input v-model="form.entCode" placeholder="请输入工厂编号" />
        </el-form-item>
        <el-form-item label="统一信用代码" prop="creditCode">
          <el-input v-model="form.creditCode" placeholder="请输入统一信用代码" />
        </el-form-item>
        <el-form-item label="工厂名称" prop="entName">
          <el-input v-model="form.entName" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="法人" prop="legalPerson">
          <el-input v-model="form.legalPerson" placeholder="请输入法人" />
        </el-form-item>
        <el-form-item label="法人手机号" prop="legalPhone">
          <el-input v-model="form.legalPhone" placeholder="请输入法人手机号" />
        </el-form-item>
        <el-form-item label="联系人" prop="linkerMan">
          <el-input v-model="form.linkerMan" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="linkerPhone">
          <el-input v-model="form.linkerPhone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="单位联系电话" prop="workPhone">
          <el-input v-model="form.workPhone" placeholder="请输入单位联系电话" />
        </el-form-item>
        <el-form-item label="详细地址" prop="entAddress">
          <el-input v-model="form.entAddress" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="营业执照号" prop="license">
          <el-input v-model="form.license" placeholder="请输入营业执照号" />
        </el-form-item>
        <el-form-item label="营业执照" prop="licensePic">
          <image-upload v-model="form.licensePic" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="经营范围" prop="busScope">
          <el-input v-model="form.busScope" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEnterpriseBase, getEnterpriseBase, delEnterpriseBase, addEnterpriseBase, updateEnterpriseBase } from "@/api/factory/enterpriseBase";

export default {
  name: "EnterpriseBase",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 工厂基本信息表格数据
      enterpriseBaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        entCode: null,
        creditCode: null,
        entName: null,
        legalPerson: null,
        legalPhone: null,
        linkerMan: null,
        linkerPhone: null,
        workPhone: null,
        entAddress: null,
        license: null,
        licensePic: null,
        busScope: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        entName: [
          { required: true, message: "工厂名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工厂基本信息列表 */
    getList() {
      this.loading = true;
      listEnterpriseBase(this.queryParams).then(response => {
        this.enterpriseBaseList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        entCode: null,
        creditCode: null,
        entName: null,
        legalPerson: null,
        legalPhone: null,
        linkerMan: null,
        linkerPhone: null,
        workPhone: null,
        entAddress: null,
        license: null,
        licensePic: null,
        remark: null,
        busScope: null,
        status: null,
        delFlag: 0,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加工厂基本信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEnterpriseBase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工厂基本信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEnterpriseBase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEnterpriseBase(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除工厂基本信息编号为"' + ids + '"的数据项？').then(function () {
        return delEnterpriseBase(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('factory/enterpriseBase/export', {
        ...this.queryParams
      }, `enterpriseBase_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
