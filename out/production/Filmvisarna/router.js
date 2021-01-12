import { createRouter, createWebHistory } from 'vue-router'

import Filmvisarna from './views/Filmvisarna.vue'
import Filmer from './views/Filmer.vue'
import Login from './views/Login.vue'
import Biljetter from './views/Biljetter.vue'

const routes = [
  {
    path: '/',
    name: 'Filmvisarna',
    component: Filmvisarna
  },
  {
    path: '/filmer', // dynamic $route.params.id
    name: 'Filmer',
    component: Filmer
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/biljetter',
    name: 'Biljetter',
    component: Biljetter
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
})