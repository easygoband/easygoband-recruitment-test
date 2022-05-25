import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

Vue.directive('outside-click', {
      bind: function(el, binding, vnode) {
            el.outside = function(event) {
                  event.stopPropagation()
                  if(!(el == event.target || el.nextSibling.contains(event.target))) {
                        vnode.context[binding.expression](event);
                  }
            }
            document.addEventListener('click', el.outside);
      },
      unbind: function(el) {
            document.removeEventListener('click', el.outside);
      }
})

new Vue({
  render: h => h(App),
}).$mount('#app')
