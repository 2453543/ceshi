import Vue from 'vue'
import VueRouter from 'vue-router'
import loginview from "@/views/loginview.vue";
import CommonView from "@/views/CommonView.vue";
import courtsinfoView from "@/views/courtsinfoView.vue";
import bookinginfoView from "@/views/bookinginfoView.vue";
import basketballcourseView from "@/views/basketballcourseView.vue";
import equipmentliststView from "@/views/equipmentliststView.vue";
import sgvideoView from "@/views/sgvideoView.vue";
import usersView from "@/views/usersView.vue";
import publicView from "@/views/publicView.vue";

Vue.use(VueRouter)



const routes = [
  {
    path: '/',
    name: 'login',
    component: loginview
  },
  {
    path: '/courtsinfo',
    name: 'courtsinfo',
    component:CommonView,
    children:[{path:'',component:courtsinfoView}]
  },

  {
    path: '/bookinginfo',
    name: 'bookinginfo',
    component:CommonView,
    children:[{path:'',component:bookinginfoView}]
  },
  {
    path: '/basketballcourseView',
    name: 'basketballcourseView',
    component:CommonView,
    children:[{path:'',component:basketballcourseView}]
  },
  {
    path: '/equipmentlistst',
    name: 'equipmentlistst',
    component:CommonView,
    children:[{path:'',component:equipmentliststView}]
  },
  {
    path: '/sgvideo',
    name: 'sgvideo',
    component:CommonView,
    children:[{path:'',component:sgvideoView}]
  },
  {
    path: '/users',
    name: 'users',
    component:CommonView,
    children:[{path:'',component:usersView}]
  },
  {
    path: '/public',
    name: 'public',
    component:CommonView,
    children:[{path:'',component:publicView}]
  },

]

const router = new VueRouter({
  routes
})

export default router
