<template>
 <div>
   <el-dialog
       title="欢迎登陆系统"
       :show-close="false"
       :close-on-press-escape="false"
       :close-on-click-modal="false"
       :visible.sync="dialogVisible"
       width="60%"
       >
     <el-form ref="form" :model="form" label-width="80px">
       <el-form-item label="账号">
         <el-input v-model="form.username"></el-input>
       </el-form-item>
         <el-form-item label="密码">
           <el-input type="password"  v-model="form.password"></el-input>
         </el-form-item>

       <el-form-item label="账号类型">
         <el-radio-group v-model="form.usertype">
           <el-radio :label="'admin'">管理员</el-radio>
           <el-radio :label="'dev'">开发者</el-radio>
         </el-radio-group>
       </el-form-item>

       <el-form-item>
         <!-- 修改按钮文本为登录 -->
         <el-button type="primary" @click="onSubmit">登录</el-button>
         <el-button >取消</el-button>
       </el-form-item>
     </el-form>


   </el-dialog>

 </div>
</template>

<script>

export default {
  name: 'loginView',
  data(){
    return{
      dialogVisible:true,
      form:{
        username:'',
        password:'',
          usertype:''
      }
    }
  },
  methods:{
    onSubmit(){
     this.$router.push("/public")
    }
  }
}
</script>
