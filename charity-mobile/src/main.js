import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
// const url = window.location.href
// const location = url.slice(0, url.indexOf(":80"))
// const baseURL =  `${location}:8081`

// 测试
// axios.defaults.baseURL="http://129.204.114.48:8081"
// 正式
axios.defaults.baseURL="http://39.105.77.161:8081"

Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
