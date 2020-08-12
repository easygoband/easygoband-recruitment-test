import Vue from "vue"
import Router from "vue-router"
import Home from "./components/Home.vue"

Vue.use(Router)

export default new Router({
    mode: "history",
    //!!! to process.env
    base: "localhost:8080",
    routes:[
        {
            path:"/",
            name: "home",
            component: Home,
            props:true
        }
    ]
})