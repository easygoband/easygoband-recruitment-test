<template>
  <v-app>
    <Header />

    <v-main>
      <Table />
    </v-main>

    <Footer />
  </v-app>
</template>

<script>
import Header from "./components/Header.vue";
import Table from "./components/Table.vue";
import Footer from "./components/Footer.vue";

export default {
  name: "App",

  components: {
    Header,
    Table,
    Footer,
  },

  data: () => ({
    //
  }),
};
</script>
