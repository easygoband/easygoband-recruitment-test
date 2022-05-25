<template>
  <div id="app">
    <app-header />
    <app-main />
    <app-footer />
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader.vue'
import AppMain from '@/components/AppMain.vue'
import AppFooter from '@/components/AppFooter.vue'

export default {
  name: 'App',
  components: {
    AppHeader,
    AppMain,
    AppFooter,
  }
}
</script>

<style>
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css");
@import './styles/colors.css';

* {
    box-sizing: border-box;
    padding: 0;
    margin: 0;
}
html {
    font-size: 62.5%;
}

#app {
    font-family: sans-serif;
    font-size: 1.6em;
    color: var(--primary-gray-fg);
}
</style>
