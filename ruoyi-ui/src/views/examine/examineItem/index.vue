<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="120px">
      <el-form-item label="体检项名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入体检项名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="性别推荐" prop="sexStatus">
        <el-select v-model="queryParams.sexStatus" placeholder="请选择性别推荐" clearable>
          <el-option v-for="dict in dict.type.examine_item_sex_status" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="默认状态" prop="defaultStatus">
        <el-select v-model="queryParams.defaultStatus" placeholder="请选择默认状态" clearable>
          <el-option v-for="dict in dict.type.examine_item_default_status" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="个人中心状态" prop="showUser">
        <el-select v-model="queryParams.showUser" placeholder="请选择个人中心状态" clearable>
          <el-option v-for="dict in dict.type.examine_item_show_user" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
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
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="examineItemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="体检项名称" align="center" prop="name" />
      <el-table-column label="参考值" align="center" prop="referenceValue" />
      <el-table-column label="性别推荐" align="center" prop="sexStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.examine_item_sex_status" :value="scope.row.sexStatus" />
        </template>
      </el-table-column>
      <el-table-column label="默认状态" align="center" prop="defaultStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.examine_item_default_status" :value="scope.row.defaultStatus" />
        </template>
      </el-table-column>
      <el-table-column label="个人中心状态" align="center" prop="showUser">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.examine_item_show_user" :value="scope.row.showUser" />
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改项对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="体检项名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入体检项名称" />
        </el-form-item>
        <el-form-item label="参考值" prop="referenceValue">
          <el-input v-model="form.referenceValue" placeholder="请输入参考值" />
        </el-form-item>
        <el-form-item label="性别限制" prop="sexStatus">
          <el-select v-model="form.sexStatus" placeholder="请选择性别限制" style="width: 100%;" clearable>
            <el-option v-for="dict in dict.type.examine_item_sex_status" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="默认状态" prop="defaultStatus">
          <el-select v-model="form.defaultStatus" placeholder="请选择默认状态" style="width: 100%;" clearable>
            <el-option v-for="dict in dict.type.examine_item_default_status" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="个人中心状态" prop="showUser">
          <el-select v-model="form.showUser" placeholder="请选择个人中心状态" style="width: 100%;" clearable>
            <el-option v-for="dict in dict.type.examine_item_show_user" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listExamineItem, getExamineItem, delExamineItem, addExamineItem, updateExamineItem } from "@/api/examine/examineItem";

export default {
  name: "ExamineItem",
  dicts: ['examine_item_sex_status', 'examine_item_default_status', 'examine_item_show_user'],
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
      // 项表格数据
      examineItemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        referenceValue: null,
        sexStatus: null,
        defaultStatus: null,
        showUser: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "体检项名称不能为空", trigger: "change" }
        ],
        referenceValue: [
          { required: true, message: "参考值不能为空", trigger: "change" }
        ],
        sexStatus: [
          { required: true, message: "性别限制不能为空", trigger: "change" }
        ],
        defaultStatus: [
          { required: true, message: "默认状态不能为空", trigger: "change" }
        ],
        showUser: [
          { required: true, message: "个人中心状态不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项列表 */
    getList() {
      this.loading = true;
      listExamineItem(this.queryParams).then(response => {
        this.examineItemList = response.rows;
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
        name: null,
        referenceValue: null,
        defaultStatus: null,
        showUser: null,
        remark: null,
        status: null,
        delFlag: null,
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
      this.title = "添加体检项";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExamineItem(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改体检项";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExamineItem(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExamineItem(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除体检项编号为"' + ids + '"的数据项？').then(function () {
        return delExamineItem(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/examineItem/export', {
        ...this.queryParams
      }, `examineItem_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
