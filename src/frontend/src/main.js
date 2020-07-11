import 'core-js/stable'
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import App from './App'
import axios from 'axios' // import axios
//import router from './router'
import router from './router/index.js'
import CoreuiVue from '@coreui/vue'
import { iconsSet as icons } from './assets/icons/icons.js'
import store from './store'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.prototype.$axios = axios; // prototype에 axios 추가

Vue.config.productionTip = false
Vue.use(BootstrapVue)

Vue.config.performance = true
Vue.use(CoreuiVue)
Vue.prototype.$log = console.log.bind(console)


new Vue({
  el: '#app',
  router,
  store,
  icons,
  template: '<App/>',
  components: {
    App
  }
})
