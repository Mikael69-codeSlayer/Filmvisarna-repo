import Vue from 'vue'
import VueRouter from 'vue-router'

// We need the components we use as distinct page views:
import Filmvisarna from '@/views/Filmvisarna.vue'
import Movies from '@/views/Movies.vue'
import Login from '@/views/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'filmvisarna',
    component: Filmvisarna
  },
  {
    path: '/movies/:id', // dynamic $route.params.id
    name: 'movies',
    component: Movies
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
