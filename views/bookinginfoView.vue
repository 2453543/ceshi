<template>
  <div class="about">
    <h1>订单管理界面</h1>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="bookingid"
          label="订单编号">
      </el-table-column>
      <el-table-column
          prop="courtnumber"
          label="场地编号">
      </el-table-column>
      <el-table-column
          prop="bookingdateStr"
          label="场地日期">
      </el-table-column>
      <el-table-column
          prop="starttimeStr"
          label="开始时间">
      </el-table-column>
      <el-table-column
          prop="endtimeStr"
          label="结束时间">
      </el-table-column>
      <el-table-column
          prop="bookingstatus"
          label="订单状态">
      </el-table-column>
      <el-table-column
          label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="deleteBooking(scope.row)">删除</el-button>
          <el-button size="mini" type="success" @click="confirmBooking(scope.row)">确认</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        :current-page="pageNum"
        page-size="5"
        @current-change="changePageNum"
        :page-count="pages"
        layout="prev, pager, next"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
import { getbookingsPage, deleteBooking, confirmBooking } from '@/api/app';

export default {
  name: 'APPView',
  data() {
    return {
      tableData: [],
      pages: 0,
      total: 0,
      pageNum: 1,
      formInline: {
        courttype: '',
        capacity: ''
      }
    };
  },
  methods: {
    changePageNum(value) {
      this.pageNum = value;
      this.getPage();
    },
    getPage() {
      getbookingsPage(this.formInline, this.pageNum).then(res => {
        if (res.code === 2000) {
          this.tableData = res.data.list;
          this.pageNum = res.data.pageNum;
          this.pages = res.data.pages;
          this.total = res.data.total;
        }
      });
    },
    toUpdate() {
      // 待实现
    },
    toDel() {
      // 待实现
    },
    onSubmit() {
      this.pageNum = 1;
      this.getPage();
    },
    deleteBooking(row) {
      this.$confirm('确定要删除该订单吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBooking(row.bookingid).then(res => {
          if (res.code === 2000) {
            this.$message.success(res.mess);
            this.getPage();
          } else {
            this.$message.error(res.mess);
          }
        });
      }).catch(() => {
        this.$message.info('已取消删除');
      });
    },
    confirmBooking(row) {
      confirmBooking(row.bookingid).then(res => {
        if (res.code === 2000) {
          this.$message.success(res.mess);
          this.getPage();
        } else {
          this.$message.error(res.mess);
        }
      });
    }
  },
  created() {
    this.getPage();
  }
};
</script>