import Vue from "vue";
import Router from "vue-router";
import AboutCmp from './components/AboutCmp.vue'
import BlogsList from './components/BlogsList.vue'
Vue.use(Router);

export default new Router({
  
  routes: [
 
    {
        path: '/about',
        name: 'About',
        component: AboutCmp
      },
      {
        path: '/blogs',
        name: 'Blog',
        component: BlogsList
      }

  ]
});