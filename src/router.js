import { createRouter, createWebHistory } from 'vue-router'

import Filmvisarna from './views/Filmvisarna.vue'
import Filmer from './views/Filmer.vue'
import Login from './views/Login.vue'
import Movieshowings from './views/Movieshowings.vue'
import FilmerDetails from './views/FilmerDetails.vue'
import SkapaKonto from './views/SkapaKonto.vue'
import MinaSidor from "./views/MinaSidor.vue"
import Salons from "./views/Salons.vue";
import Tickets from "./views/Tickets.vue";

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
    name: 'Movieshowings',
    path: '/movieshowings/:id',
    component: Movieshowings
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
  },
  {
    name: 'Salons',
    path: '/salons',
    component: Salons
  },
  {
    name: 'Tickets',
    path: '/tickets/:id',
    component: Tickets
  }
]

export default createRouter({
  history: createWebHistory(),
  routes,
})

