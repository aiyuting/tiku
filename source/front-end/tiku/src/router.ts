import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/web/',
  // todo 根据menu信息自动生成路由表
  routes: [
    {
      path: '/',
      name: 'home',

      component: () => import('./views/Home.vue')
    },
    {
      path: '/about',
      name: 'about',

      component: () => import(/* webpackChunkName: "About" */ './views/About.vue')
    },
    {
      path: '/InputTiku',
      name: 'InputTiku',

      component: () => import(/* webpackChunkName: "InputTiku" */ './components/InputTiku.vue')
    },
    {
      path: '/TikuTable',
      name: 'TikuTable',

      component: () => import(/* webpackChunkName: "TikuTable" */ './components/TikuTable.vue')
    },
    {
      path: '/VerifyTable',
      name: 'VerifyTable',

      component: () => import(/* webpackChunkName: "VerifyTable" */ './components/VerifyTable.vue')
    },
    {
      path: '/ViewProblem',
      name: 'ViewProblem',

      component: () => import(/* webpackChunkName: "ViewProblem" */ './components/ViewProblem.vue')
    },
    {
      path: '/ModifyProblem',
      name: 'ModifyProblem',

      component: () => import(/* webpackChunkName: "ModifyProblem" */ './components/ModifyProblem.vue')
    },
    // {
    //   path: '/PaperTable',
    //   name: 'PaperTable',
    //   component: () => import(/* webpackChunkName: "PaperTable" */ './components/PaperTable.vue')
    // },
    {
      path: '/BasicTable',
      name: 'BasicTable',

      component: () => import(/* webpackChunkName: "BasicTable" */ './components/BasicTable.vue')
    },
    {
      path: '/ViewTags',
      name: 'ViewTags',

      component: () => import(/* webpackChunkName: "ViewTags" */ './components/ViewTags.vue')
    },
    {
      path: '/PaperList',
      name: 'PaperList',
      component: () => import(/* webpackChunkName: "PaperList" */ './views/PaperList.vue')
    },
    {
      path: '/CreatePaper',
      name: 'CreatePaper',
      component: () => import(/* webpackChunkName: "CreatePaper" */ './components/CreatePaper.vue')
    },
    {
      path: '/ViewPaper',
      name: 'ViewPaper',
      component: () => import(/* webpackChunkName: "ViewPaper" */ './views/ViewPaper.vue')
    }
  ]
})
