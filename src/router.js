import { createRouter, createWebHistory } from 'vue-router'

import Filmvisarna from './views/Filmvisarna.vue'
import Movies from './views/Movies.vue'
import Login from './views/Login.vue'

const routes = [
  {
    path: '/',
    name: 'Filmvisarna',
    component: Filmvisarna
  },
  {
    path: '/movies/:id', // dynamic $route.params.id
    name: 'Movies',
    component: Movies
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
})