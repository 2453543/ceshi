<template>
  <div class="about">
    <h1>篮球馆预订管理界面</h1>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">

      <el-form-item label="场地类型">
        <el-input v-model="formInline.courttype" placeholder="场地类型"></el-input>
      </el-form-item>

      <el-form-item label="场地容纳人数">
        <el-input v-model="formInline.capacity" placeholder="场地容纳人数"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
        prop="courtnumber"
        label="场地编号">
    </el-table-column>
    <el-table-column
        prop="courttype"
        label="场地类型">
    </el-table-column>
      <el-table-column
          prop="capacity"
          label="场地容纳人数">
      </el-table-column>
      <el-table-column
          prop="state"
          label="场地状态">
      </el-table-column>
      <el-table-column
          label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="success" @click="openCourt(scope.row)">开启</el-button>
          <el-button size="mini" type="danger" @click="closeCourt(scope.row)">关闭</el-button>
          <el-button size="mini" type="primary" @click="openBookingDialog(scope.row)">预订</el-button>
          <el-button size="mini" type="warning" @click="openModifyDialog(scope.row)">修改</el-button>
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

    <el-dialog :visible.sync="bookingDialogVisible" title="场地预订">
      <el-form :model="bookingForm" label-width="120px">

        <el-form-item label="场地编号">
          <el-input v-model="bookingForm.courtnumber" readonly></el-input>
        </el-form-item>
        <el-form-item label="场地类型">
          <el-input v-model="bookingForm.courttype" readonly></el-input>
        </el-form-item>
        <el-form-item label="用户 ID">
          <el-input v-model="bookingForm.userid" placeholder="请输入用户 ID"></el-input>
        </el-form-item>
        <el-form-item label="预订日期">
          <el-date-picker
              v-model="bookingForm.bookingdate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-time-picker
              v-model="bookingForm.starttime"
              placeholder="选择开始时间">
          </el-time-picker>
        </el-form-item>
        <el-form-item label="结束时间">
          <el-time-picker
              v-model="bookingForm.endtime"
              placeholder="选择结束时间">
          </el-time-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitBooking">确定</el-button>
        <el-button @click="bookingDialogVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- 添加修改弹窗 -->
    <el-dialog :visible.sync="modifyDialogVisible" title="修改场地信息">
      <el-form :model="modifyForm" label-width="120px">
        <el-form-item label="场地编号">
          <el-input v-model="modifyForm.courtnumber" readonly></el-input>
        </el-form-item>
        <el-form-item label="场地类型">
          <el-select v-model="modifyForm.courttype" placeholder="请选择场地类型">
            <el-option label="标准场地" value="标准场地"></el-option>
            <el-option label="专业场地" value="专业场地"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="场地容纳人数">
          <el-input-number
              v-model="modifyForm.capacity"
              :min="10"
              :max="100"
              placeholder="请输入场地容纳人数">
          </el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="modifyDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitModify">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>



<script>
import { getcourtsPage, updateCourtState, createBooking, updateCourtInfo } from '@/api/app';

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
      },
      bookingDialogVisible: false,
      bookingForm: {
        courtnumber: '',
        courttype: '',
        bookingdate: null,
        starttime: null,
        endtime: null
      },
      // 添加修改弹窗相关数据
      modifyDialogVisible: false,
      modifyForm: {
        courtnumber: '',
        courttype: '',
        capacity: 0
      }
    };
  },
  methods: {
    changePageNum(value) {
      this.pageNum = value;
      this.getPage();
    },
    getPage() {
      getcourtsPage(this.formInline, this.pageNum).then(res => {
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
    openCourt(court) {
      court.state = '开启';
      this.updateCourtState(court);
    },
    closeCourt(court) {
      court.state = '关闭';
      this.updateCourtState(court);
    },
    updateCourtState(court) {
      updateCourtState(court).then(res => {
        if (res.code === 2000) {
          this.$message.success(res.mess);
          this.getPage(); // 更新表格数据
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    openBookingDialog(row) {
      if (row.state === '关闭') {
        this.$alert('当前场地已经关闭', '提示', {
          confirmButtonText: '确定'
        });
        return;
      }
      this.bookingDialogVisible = true;
      this.bookingForm.courtnumber = row.courtnumber;
      this.bookingForm.courttype = row.courttype;
    },
    submitBooking() {
      createBooking(this.bookingForm).then(res => {
        if (res.code === 2000) {
          this.$message.success(res.mess);
          this.bookingDialogVisible = false;
          this.getPage(); // 更新场地列表
          // 刷新订单页面
          this.$router.push({ name: 'bookinginfo' }).then(() => {
            this.$router.go(0);
          });
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    // 添加打开修改弹窗的方法
    openModifyDialog(row) {
      this.modifyDialogVisible = true;
      this.modifyForm.courtnumber = row.courtnumber;
      this.modifyForm.courttype = row.courttype;
      this.modifyForm.capacity = row.capacity;
    },
    // 添加提交修改信息的方法

    submitModify() {
      updateCourtInfo(this.modifyForm).then(res => {
        if (res.code === 2000) {
          this.$message.success(res.mess);
          this.modifyDialogVisible = false;
          this.getPage(); // 更新场地列表
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