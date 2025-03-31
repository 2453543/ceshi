<template>
  <div class="about">
    <h1>教学视频界面</h1>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="title"
          label="视频标题">
      </el-table-column>
      <el-table-column
          label="封面图片">
        <template slot-scope="scope">
          <img :src="scope.row.logopicpath" alt="" style="height: 50px;width: 50px">
        </template>
      </el-table-column>

      <el-table-column
          prop="origin"
          label="视频博主">
      </el-table-column>

      <el-table-column
          prop="createtimeStr"
          label="视频上架时间">
      </el-table-column>
      <el-table-column
          prop="updatetimeStr"
          label="视频最近更新时间">
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
import {getsgvideoPage} from "@/api/app";

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
      getsgvideoPage(this.formInline,this.pageNum).then(res =>{
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


