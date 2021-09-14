<template>
  <div id="app">
    <img class="logo" alt="Logo" src="./assets/easygoband-logo.png">
    <Table/>
  </div>
</template>

<script>
import Table from './components/table/table.component.vue'
export default {
  name: 'App',
  components: {
    Table,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.logo{

  width: 30%;
}

</style>
