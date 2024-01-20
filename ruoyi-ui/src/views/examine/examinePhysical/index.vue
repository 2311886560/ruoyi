<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="医务人员用户ID" prop="medicalUserId">
        <el-input v-model="queryParams.medicalUserId" placeholder="请输入医务人员用户ID" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <!-- <el-form-item label="老干部用户ID" prop="retiredUserId">
        <el-input v-model="queryParams.retiredUserId" placeholder="请输入老干部用户ID" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <el-form-item label="体检标题" prop="title">
        <el-input v-model="queryParams.title" placeholder="请输入体检标题" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <!-- <el-form-item label="体检时间" prop="examineTime">
        <el-date-picker clearable v-model="queryParams.examineTime" type="date" value-format="yyyy-MM-dd"
          placeholder="请选择体检时间">
        </el-date-picker>
      </el-form-item> -->
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

    <el-table v-loading="loading" :data="examinePhysicalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="医务人员用户ID" align="center" prop="medicalUserId" />
      <el-table-column label="老干部用户ID" align="center" prop="retiredUserId" />
      <el-table-column label="体检标题" align="center" prop="title" />
      <el-table-column label="体检内容" align="center" prop="content" />
      <el-table-column label="体检时间" align="center" prop="examineTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.examineTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="审核状态" align="center" prop="processStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.examine_physical_process_status" :value="scope.row.processStatus" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改数据信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="体检标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入体检标题" />
        </el-form-item>
        <el-form-item label="医务人员" prop="medicalUserId">
          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.medicalUserId"
            placeholder="请选择医务人员">
            <el-option v-for="item in medicalUserOptions" :key="item.value" :label="item.label"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="老干部" prop="retiredUserId">
          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.retiredUserId"
            placeholder="请选择老干部">
            <el-option v-for="item in retiredUserOptions" :key="item.value" :label="item.label"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="体检内容">
          <el-input :disabled="openType === 'details'" v-model="form.content" placeholder="请输入体检内容" maxlength="50" />
        </el-form-item>
        <el-form-item label="体检时间" prop="examineTime">
          <el-date-picker style="width: 100%;" :disabled="openType === 'details'" clearable v-model="form.examineTime" type="date"
            value-format="yyyy-MM-dd" placeholder="请选择体检时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核状态" prop="processStatus">
          <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="form.processStatus"
            placeholder="请选择审核状态">
            <el-option v-for="item in dict.type.examine_physical_process_status" :key="item.value" :label="item.label"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-divider content-position="center">商品信息</el-divider>
        <el-row :gutter="10" class="mb8" v-if="openType !== 'details'">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini"
              @click="handleAddExaminePhysicalDetail">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteExaminePhysicalDetail">删除
            </el-button>
          </el-col>
        </el-row>
        <el-table :data="examinePhysicalDetailList" :row-class-name="rowExaminePhysicalDetailIndex"
          @selection-change="handleExaminePhysicalDetailSelectionChange" ref="examinePhysicalDetail">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50" />
          <el-table-column label="体检项目" width="150">
            <template slot-scope="scope">
              <el-select :disabled="openType === 'details'" style="width: 100%;" v-model="scope.row.itemId"
                placeholder="请选择体检项目" clearable filterable @change="(e) => onChangeExamineItem(e, scope.row)">
                <el-option v-for="item in examineItemOptions" :key="item.value" :label="item.label"
                  :value="item.value"></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="参考值" prop="referenceValue" width="150">
            <template slot-scope="scope">
              <span>{{ scope.row.referenceValue }}</span>
            </template>
          </el-table-column>
          <el-table-column label="体检结果" prop="value" width="150">
            <template slot-scope="scope">
              <el-input :disabled="openType === 'details'" v-model="scope.row.value" maxlength="10"
                placeholder="请输入体检结果" />
            </template>
          </el-table-column>
          <el-table-column label="体检时间" prop="examineTime" width="220">
            <template slot-scope="scope">
              <el-date-picker style="width: 100%;" :disabled="openType === 'details'" clearable v-model="scope.row.examineTime" type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss" placeholder="请选择体检时间">
              </el-date-picker>
            </template>
          </el-table-column>
          <el-table-column label="备注" prop="remark" width="250">
            <template slot-scope="scope">
              <el-input :disabled="openType === 'details'" v-model="scope.row.remark" maxlength="10"
                placeholder="请输入备注" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listExaminePhysical, getExaminePhysical, delExaminePhysical, addExaminePhysical, updateExaminePhysical } from "@/api/examine/examinePhysical";
import { listExamineItem } from "@/api/examine/examineItem";
import { listUser } from "@/api/system/user";
import { getInfo } from '@/api/login'

export default {
  name: "ExaminePhysical",
  dicts: ['examine_physical_process_status', 'examine_item_default_status', 'examine_item_show_user'],
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
      // 数据信息表格数据
      examinePhysicalList: [],
      // 体检数据详细表格数据
      examinePhysicalDetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 弹出层类型化
      openType: 'details',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        medicalUserId: null,
        retiredUserId: null,
        title: null,
        content: null,
        examineTime: null,
        processStatus: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 用户信息
      userInfo: {
        userType: '00'
      },
      // 医务人员用户选项
      medicalUserOptions: [],
      // 老干部用户选项
      retiredUserOptions: [],
      // 可选的体检项目列表
      examineItemOptions: {},
    };
  },
  created() {
    this.getList();
    this.getUserInfo();
    this.getExamineItemOption();
    this.getUserOption();
  },
  methods: {
    onChangeExamineItem(e, row) {
      let obj = this.examineItemOptions.find((item) => item.value === e)
      row.referenceValue = obj.referenceValue
    },
    // 查询登录用户信息
    getUserInfo() {
      getInfo().then(response => {
        this.userInfo = response.user;
      })
    },
    // 查询用户列表
    getUserOption() {
      listUser({ pageNum: 1, pageSize: 999, userType: '11' }).then(response => {
        this.medicalUserOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.nickName, value: item.userId }
          return c;
        })
      })
      listUser({ pageNum: 1, pageSize: 999, userType: '21' }).then(response => {
        this.retiredUserOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.nickName, value: item.userId }
          return c;
        })
      })
    },
    // 查询体检项目列表
    getExamineItemOption() {
      listExamineItem({ pageNum: 1, pageSize: 999 }).then(response => {
        this.examineItemOptions = response.rows.map((item, index, arr) => {
          let c = { label: item.name, value: item.id, ...item }
          return c;
        })
      })
    },
    /** 查询数据信息列表 */
    getList() {
      this.loading = true;
      listExaminePhysical(this.queryParams).then(response => {
        this.examinePhysicalList = response.rows;
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
        medicalUserId: null,
        retiredUserId: null,
        title: null,
        content: null,
        examineTime: null,
        remark: null,
        processStatus: null,
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
      this.openType = 'add';
      this.title = "添加数据信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExaminePhysical(id).then(response => {
        this.form = response.data;
        this.examinePhysicalDetailList = response.data.examinePhysicalDetailList;
        this.open = true;
        this.openType = 'update';
        this.title = "修改数据信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.examinePhysicalDetailList = this.examinePhysicalDetailList;
          if (this.form.id != null) {
            updateExaminePhysical(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExaminePhysical(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除数据信息编号为"' + ids + '"的数据项？').then(function () {
        return delExaminePhysical(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 体检数据详细序号 */
    rowExaminePhysicalDetailIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 体检数据详细添加按钮操作 */
    handleAddExaminePhysicalDetail() {
      let obj = {};
      this.examinePhysicalDetailList.push(obj);
    },
    /** 体检数据详细删除按钮操作 */
    handleDeleteExaminePhysicalDetail() {
      if (this.checkedExaminePhysicalDetail.length == 0) {
        this.$modal.msgError("请先选择要删除的体检数据详细数据");
      } else {
        const examinePhysicalDetailList = this.examinePhysicalDetailList;
        const checkedExaminePhysicalDetail = this.checkedExaminePhysicalDetail;
        this.examinePhysicalDetailList = examinePhysicalDetailList.filter(function (item) {
          return checkedExaminePhysicalDetail.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleExaminePhysicalDetailSelectionChange(selection) {
      this.checkedExaminePhysicalDetail = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/examinePhysical/export', {
        ...this.queryParams
      }, `examinePhysical_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
