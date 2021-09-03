import Vue from 'vue'
import App from './App.vue'


// añadimos librerias de font awesome
import {library} from '@fortawesome/fontawesome-svg-core'
import {fas} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'


//añadimos un componenete para poder usar iconos de font awesome en nuestro html
library.add(fas)
Vue.component('fa',FontAwesomeIcon)



Vue.config.productionTip = false

new Vue({

  render: h => h(App)
}).$mount('#app')
