<template>
  <div class="about">
    <h1>用户界面</h1>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="useridname"
          label="用户账号名字">
      </el-table-column>
      <el-table-column
          prop="username"
          label="用户真实名字">
      </el-table-column>

      <el-table-column
          prop="phone"
          label="用户电话号码">
      </el-table-column>
      <el-table-column
          prop="email"
          label="用户邮箱">
      </el-table-column>
      <el-table-column
          prop="usertype"
          label="账号类型">
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



<script >
import {getusersPage} from "@/api/app";

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

      }
    }
  },
  methods:{
    changePageNum(value){
      this.pageNum=value
      this.getPage()

    },
    getPage(){
      getusersPage(this.formInline,this.pageNum).then(res =>{
        console.log(res)
        if(res.code == 2000){
          this.tableData=res.data.list
          this.pageNum=res.data.pageNum
          this.pages=res.data.pages
          this.total=res.data.total
          // eslint-disable-next-line no-empty

        }
      })
    },
    toUpdate(){

    },
    toDel(){

    },

    onSubmit(){
      this.pageNum=1
      this.getPage()

    }
  },
  created() {
    this.getPage()
  }

}


</script>