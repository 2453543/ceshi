<template>
  <div class="about">
    <h1>设备界面</h1>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="userid"
          label="用户id">
      </el-table-column>
      <el-table-column
          prop="equipmentid"
          label="篮球id">
      </el-table-column>

      <el-table-column
          prop="borrowdateStr"
          label="最近借出时间">
      </el-table-column>
      <el-table-column
          prop="returndateStr"
          label="最近归还时间">
      </el-table-column>
      <el-table-column
          prop="borrowingstatus"
          label="状态">
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
import {getequipmentliststPage} from "@/api/app";

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
      getequipmentliststPage(this.formInline,this.pageNum).then(res =>{
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
