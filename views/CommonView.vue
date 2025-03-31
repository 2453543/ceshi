<template>


  <el-container style="height: 100vh; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router default-active="/public" :default-openeds="['1']">

        <el-menu-item index="/public"><i class="el-icon-menu"></i>主页-篮球网馆管理界面</el-menu-item>
        <el-menu-item index="/courtsinfo"><i class="el-icon-menu"></i>场地预订</el-menu-item>
        <el-menu-item index="/bookinginfo"><i class="el-icon-menu"></i>场地预订订单管理</el-menu-item>
        <el-menu-item index="/basketballcourseView"><i class="el-icon-menu"></i>查看篮球培训课程信息</el-menu-item>
        <el-menu-item index="/equipmentlistst"><i class="el-icon-menu"></i>篮球设备</el-menu-item>
        <el-menu-item index="/sgvideo"><i class="el-icon-menu"></i>视频界面</el-menu-item>
        <el-menu-item index="/users"><i class="el-icon-menu"></i>用户界面</el-menu-item>


        </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>切换账号</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>

      <el-main>
        <router-view/>
      </el-main>

    </el-container>
  </el-container>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  data() {

    return {

    }
  }
};
</script>
<script setup>
</script>