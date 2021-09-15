<template>
  <main>
    <Header />
    <div class="container px-5 sm:px20 py-20 flex justify-center">
      <Table v-bind:assets="assets" />
    </div>
  </main>
</template>

<script>
import Header from "@/components/Header";
import Table from "@/components/Table";
import api from "./api";

export default {
  name: "App",
  components: { Header, Table },

  data() {
    return {
      assets: [],
    };
  },
  created() {
    api.getAssets().then((assets) => (this.assets = assets));
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
