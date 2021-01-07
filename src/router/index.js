import Vue from 'vue'
import Router from 'vue-router'

// We need the components we use as distinct page views:
import Home from '@/views/Home.vue'
import Products from '@/views/Products.vue'
import Contact from '@/views/Contact.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/products/:id', // dynamic $route.params.id
    name: 'products',
    component: Products
  },
  {
    path: '/contact',
    name: 'contact',
    component: Contact
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
