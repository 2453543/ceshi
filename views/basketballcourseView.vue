<template>
  <div class="about">
    <h1>篮球课程界面</h1>
    <el-button @click="openAddCourseDialog">新增课程</el-button>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="coursename"
          label="课程名字">
      </el-table-column>
      <el-table-column
          prop="description"
          label="课程描述">
      </el-table-column>
      <el-table-column
          prop="coachname"
          label="教练名字">
      </el-table-column>
      <el-table-column
          prop="venueid"
          label="场地编号">
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
          prop="enrolledstudents"
          label="当前报名人数">
      </el-table-column>
      <el-table-column
          prop="maxstudents"
          label="最多报名人数">
      </el-table-column>
      <el-table-column
          prop="status"
          label="状态">
      </el-table-column>
      <el-table-column
          label="操作">
        <template slot-scope="scope">
          <el-button @click="signUp(scope.row)" :disabled="scope.row.enrolledstudents >= scope.row.maxstudents">报名课程</el-button>
          <el-button @click="cancelSignUp(scope.row)" :disabled="scope.row.enrolledstudents <= 0">取消报名</el-button>
          <el-button @click="offlineCourse(scope.row)">下架课程</el-button>
          <el-button @click="onlineCourse(scope.row)" :disabled="scope.row.status!== '下架'">上架课程</el-button>
          <el-button @click="deleteCourse(scope.row)">删除课程</el-button>
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

    <el-dialog :visible.sync="addCourseDialogVisible" title="新增课程">
      <el-form :model="newCourse" ref="addCourseForm" label-width="120px">
        <el-form-item label="课程名字">
          <el-input v-model="newCourse.coursename"></el-input>
        </el-form-item>
        <el-form-item label="课程描述">
          <el-input v-model="newCourse.description"></el-input>
        </el-form-item>
        <el-form-item label="教练名字">
          <el-input v-model="newCourse.coachname"></el-input>
        </el-form-item>
        <el-form-item label="场地编号">
          <el-select v-model="newCourse.venueid" placeholder="请选择场地编号">
            <el-option
                v-for="venue in venues"
                :key="venue"
                :label="venue"
                :value="venue">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-date-picker
              v-model="newCourse.starttime"
              type="datetime"
              placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间">
          <el-date-picker
              v-model="newCourse.endtime"
              type="datetime"
              placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最大报名人数">
          <el-input-number v-model="newCourse.maxstudents" :min="1" :max="20"></el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addCourseDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addCourse">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script >
import {getbasketballcoursePage, signUpCourse, cancelSignUpCourse, offlineCourseApi, onlineCourseApi, deleteCourseApi, addCourseApi} from "@/api/app";

export default {
  name: 'APPView',
  data() {
    return {
      tableData: [],
      pages:0,
      total:0,
      pageNum:1,
      formInline:{
        courttype: '',
        capacity: ''
      },
      addCourseDialogVisible: false,
      newCourse: {
        coursename: '',
        description: '',
        coachname: '',
        venueid: '',
        starttime: null,
        endtime: null,
        enrolledstudents: 0,
        maxstudents: 1,
        status: '开放'
      },
      venues: ['C001', 'C002', 'C003', 'C004', 'C005', 'C006', 'C007', 'C008', 'C009', 'C010']
    }
  },
  methods:{
    changePageNum(value){
      this.pageNum=value
      this.getPage()
    },
    getPage(){
      getbasketballcoursePage(this.formInline,this.pageNum).then(res =>{
        console.log(res)
        if(res.code == 2000){
          this.tableData=res.data.list
          this.pageNum=res.data.pageNum
          this.pages=res.data.pages
          this.total=res.data.total
        }
      })
    },
    signUp(course) {
      if (course.status === '下架') {
        this.$message.error('课程已下架，无法报名');
        return;
      }
      signUpCourse(course.courseid).then(res => {
        if (res.code === 2000) {
          course.enrolledstudents++;
          if (course.enrolledstudents === course.maxstudents) {
            course.status = '已满';
          }
          this.$message.success('报名成功');
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    cancelSignUp(course) {
      if (course.status === '下架') {
        this.$message.error('课程已下架，无法取消报名');
        return;
      }
      cancelSignUpCourse(course.courseid).then(res => {
        if (res.code === 2000) {
          course.enrolledstudents--;
          if (course.enrolledstudents < course.maxstudents) {
            course.status = '开放';
          }
          this.$message.success('取消报名成功');
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    offlineCourse(course) {
      offlineCourseApi(course.courseid).then(res => {
        if (res.code === 2000) {
          course.status = '下架';
          this.$message.success('课程下架成功');
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    onlineCourse(course) {
      onlineCourseApi(course.courseid).then(res => {
        if (res.code === 2000) {
          course.status = '开放';
          this.$message.success('课程上架成功');
        } else {
          this.$message.error(res.mess);
        }
      });
    },
    deleteCourse(course) {
      this.$confirm('是否删除当前课程？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteCourseApi(course.courseid).then(res => {
          if (res.code === 2000) {
            this.getPage();
            this.$message.success('课程删除成功');
          } else {
            this.$message.error(res.mess);
          }
        });
      }).catch(() => {
        this.$message.info('已取消删除');
      });
    },
    openAddCourseDialog() {
      this.addCourseDialogVisible = true;
    },
    addCourse() {
      this.$refs.addCourseForm.validate((valid) => {
        if (valid) {
          addCourseApi(this.newCourse).then(res => {
            if (res.code === 2000) {
              this.addCourseDialogVisible = false;
              this.getPage();
              this.$message.success('课程新增成功');
            } else {
              this.$message.error(res.mess);
            }
          });
        } else {
          return false;
        }
      });
    }
  },
  created() {
    this.getPage()
  }
}
</script>