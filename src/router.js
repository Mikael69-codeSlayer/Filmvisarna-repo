import { createRouter, createWebHistory } from 'vue-router'

import Filmvisarna from './views/Filmvisarna.vue'
import Filmer from './views/Filmer.vue'
import Login from './views/Login.vue'
import Biljetter from './views/Biljetter.vue'
import FilmerDetails from './views/FilmerDetails.vue'
import SkapaKonto from './views/SkapaKonto.vue'
import MinaSidor from "./views/MinaSidor.vue"
import Salons from "./views/Salons.vue";

const routes = [
  {
    name: 'FilmerDetails',
    path: '/filmerDetails/:id',
    component: FilmerDetails
  },
  {
    name: 'Filmvisarna',
    path: '/',
    component: Filmvisarna
  },
  {
    name: 'Filmer',
    path: '/filmer', 
    component: Filmer
  },
  {
    name: 'Login',
    path: '/login',
    component: Login
  },
  {
    name: 'Biljetter',
    path: '/biljetter',
    component: Biljetter
  },
  {
    name: 'SkapaKonto',
    path: '/skapaKonto',
    component: SkapaKonto
  },

  {
    name: 'MinaSidor',
    path: '/minasidor',
    component: MinaSidor
  },{
    name: 'Salons',
    path: '/salons',
    component: Salons
  }
]

export default createRouter({
  history: createWebHistory(),
  routes,
})

