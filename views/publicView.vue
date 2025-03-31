<template>
  <div>
    <h1>公告管理</h1>
    <el-table :data="announcementsTableData" style="width: 100%">
      <el-table-column prop="title" label="公告标题"></el-table-column>
      <el-table-column prop="content" label="公告内容"></el-table-column>
      <el-table-column prop="publishTime" label="发布时间"></el-table-column>
    </el-table>
    <el-pagination
        background
        :current-page="announcementsPageNum"
        page-size="5"
        @current-change="changeAnnouncementsPageNum"
        :page-count="announcementsPages"
        layout="prev, pager, next"
        :total="announcementsTotal"
    ></el-pagination>

    <h1>轮播图管理</h1>
    <el-table :data="carouseiimagesTableData" style="width: 100%">
      <el-table-column prop="imagepath" label="图片路径"></el-table-column>
      <el-table-column prop="link" label="链接"></el-table-column>
      <el-table-column prop="displayorder" label="显示顺序"></el-table-column>
    </el-table>
    <el-pagination
        background
        :current-page="carouseiimagesPageNum"
        page-size="5"
        @current-change="changeCarouseiimagesPageNum"
        :page-count="carouseiimagesPages"
        layout="prev, pager, next"
        :total="carouseiimagesTotal"
    ></el-pagination>

    <h1>体育资讯展示</h1>
    <el-table :data="sportsnewsTableData" style="width: 100%">
      <el-table-column prop="title" label="资讯标题"></el-table-column>
      <el-table-column prop="content" label="资讯内容"></el-table-column>
      <el-table-column prop="publishtime" label="发布时间"></el-table-column>
    </el-table>
    <el-pagination
        background
        :current-page="sportsnewsPageNum"
        page-size="5"
        @current-change="changeSportsnewsPageNum"
        :page-count="sportsnewsPages"
        layout="prev, pager, next"
        :total="sportsnewsTotal"
    ></el-pagination>
  </div>
</template>

<script>
import { getAnnouncementsPage, getCarouseiimagesPage, getSportsnewsPage } from '@/api/app';

export default {
  name: 'APPView',
  data() {
    return {
      announcementsTableData: [],
      announcementsPages: 0,
      announcementsTotal: 0,
      announcementsPageNum: 1,

      carouseiimagesTableData: [],
      carouseiimagesPages: 0,
      carouseiimagesTotal: 0,
      carouseiimagesPageNum: 1,

      sportsnewsTableData: [],
      sportsnewsPages: 0,
      sportsnewsTotal: 0,
      sportsnewsPageNum: 1,
    };
  },
  methods: {
    changeAnnouncementsPageNum(value) {
      this.announcementsPageNum = value;
      this.getAnnouncementsPage();
    },
    getAnnouncementsPage() {
      getAnnouncementsPage({}, this.announcementsPageNum).then((res) => {
        if (res.code === 2000) {
          this.announcementsTableData = res.data.list;
          this.announcementsPageNum = res.data.pageNum;
          this.announcementsPages = res.data.pages;
          this.announcementsTotal = res.data.total;
        }
      });
    },

    changeCarouseiimagesPageNum(value) {
      this.carouseiimagesPageNum = value;
      this.getCarouseiimagesPage();
    },
    getCarouseiimagesPage() {
      getCarouseiimagesPage({}, this.carouseiimagesPageNum).then((res) => {
        if (res.code === 2000) {
          this.carouseiimagesTableData = res.data.list;
          this.carouseiimagesPageNum = res.data.pageNum;
          this.carouseiimagesPages = res.data.pages;
          this.carouseiimagesTotal = res.data.total;
        }
      });
    },

    changeSportsnewsPageNum(value) {
      this.sportsnewsPageNum = value;
      this.getSportsnewsPage();
    },
    getSportsnewsPage() {
      getSportsnewsPage({}, this.sportsnewsPageNum).then((res) => {
        if (res.code === 2000) {
          this.sportsnewsTableData = res.data.list;
          this.sportsnewsPageNum = res.data.pageNum;
          this.sportsnewsPages = res.data.pages;
          this.sportsnewsTotal = res.data.total;
        }
      });
    },
  },
  created() {
    this.getAnnouncementsPage();
    this.getCarouseiimagesPage();
    this.getSportsnewsPage();
  },
};
</script>