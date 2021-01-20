import { createApp } from 'vue'
import App from './App.vue'
import './index.css'
import router from './router.js'
import store from './store.js'

// Vueper Slides
import { VueperSlides, VueperSlide } from 'vueperslides'
import 'vueperslides/dist/vueperslides.css'



const app = createApp(App)
app.use(store)
app.use(router)
app.mount('#app')


export default {
  components: { VueperSlides, VueperSlide },

}