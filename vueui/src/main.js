import Vue from 'vue'
import App from './App'
import fcyRouter from './router'
import storeModule from './store'
import iviewFrame from './iview'
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router:fcyRouter,
  store:storeModule,
  components: { App },
  template: '<App/>'
})
