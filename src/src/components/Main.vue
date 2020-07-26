<template>
  <v-app id="inspire">
    <Header />
    <Providers />
    <Footer />
  </v-app>
</template>

<script>
import Providers from "./Providers";
import Header from "./Header";
import Footer from "./Footer";
export default {
  components: {
    Providers,
    Header,
    Footer,
  },
  props: {
    source: String,
  },
  data: () => ({ drawer: null }),
};
</script>
