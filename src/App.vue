<template>
  <div id="app">
    <img src="./assets/Easygoband.png">
    
    <contenido/>
    
  </div>
</template>
<script src="https://cdn.jsdelivr.net/npm/vue@2.x/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vuetify@2.x/dist/vuetify.js"></script>
<script>
import contenido from './components/HelloWorld'
import vuetify  from './components/vuetify.js'








export default {
  name: 'App',
  "vuetify": vuetify,
  components: {
    contenido,
    
    
    
    
    
    

  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #030640;
  margin-top: 60px;
  

}
image{
  
}


</style>
