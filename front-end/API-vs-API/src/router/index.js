import Vue from 'vue'
import Router from 'vue-router'

import Vuetest from '@/components/Vuetest'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Vuetest',
      component: Vuetest
    }
  ]
})
