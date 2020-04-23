import Vue from 'vue'
import Router from 'vue-router'
import index from '../components/index'
import upload from "../components/upload";
import download from "../components/download";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'/index'
    },
    {
      path: '/index',
      component:index,
      children:[
        {
          path:'upload',
          components:{
            main:upload
          }
        },
        {
          path:'download',
          components:{
            main:download
          }
        }
      ]
    },

  ]
})
