<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="体检项目" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入体检项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="examinePhysicalDetailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="体检项目" align="center" prop="name" />
      <el-table-column label="参考值" align="center" prop="referenceValue" />
      <el-table-column label="体检结果" align="center" prop="value" />
      <el-table-column label="体检时间" align="center" prop="examineTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.examineTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改数据明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="体检数据ID" prop="examineId">
          <el-input v-model="form.examineId" placeholder="请输入体检数据ID" />
        </el-form-item>
        <el-form-item label="体检项ID" prop="itemId">
          <el-input v-model="form.itemId" placeholder="请输入体检项ID" />
        </el-form-item>
        <el-form-item label="体检项名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入体检项名称" />
        </el-form-item>
        <el-form-item label="体检值" prop="value">
          <el-input v-model="form.value" placeholder="请输入体检值" />
        </el-form-item>
        <el-form-item label="参考值" prop="referenceValue">
          <el-input v-model="form.referenceValue" placeholder="请输入参考值" />
        </el-form-item>
        <el-form-item label="体检时间" prop="examineTime">
          <el-date-picker clearable
            v-model="form.examineTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择体检时间">
          </el-date-picker>
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
import { listExaminePhysicalDetail, getExaminePhysicalDetail, delExaminePhysicalDetail, addExaminePhysicalDetail, updateExaminePhysicalDetail } from "@/api/examine/examinePhysicalDetail";

export default {
  name: "ExaminePhysicalDetail",
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
      // 数据明细表格数据
      examinePhysicalDetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        examineId: null,
        itemId: null,
        name: null,
        value: null,
        referenceValue: null,
        examineTime: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询数据明细列表 */
    getList() {
      this.loading = true;
      listExaminePhysicalDetail(this.queryParams).then(response => {
        this.examinePhysicalDetailList = response.rows;
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
        examineId: null,
        itemId: null,
        name: null,
        value: null,
        referenceValue: null,
        examineTime: null,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加数据明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExaminePhysicalDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改数据明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExaminePhysicalDetail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExaminePhysicalDetail(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除数据明细编号为"' + ids + '"的数据项？').then(function() {
        return delExaminePhysicalDetail(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/examinePhysicalDetail/export', {
        ...this.queryParams
      }, `examinePhysicalDetail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
