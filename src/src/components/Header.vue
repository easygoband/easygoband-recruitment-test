<template>
  <v-app-bar class="header" app color="#000230" dark>
    <v-toolbar-title :class="`d-flex align-center`">
      <img
        src="https://www.easygoband.com/wp-content/themes/easygoband/dist/assets/images/logo-easygoband.svg"
        alt="Easygoband"
      />
      <span>Recruitment Test</span>
    </v-toolbar-title>
    <div class="gradient-primary"></div>
  </v-app-bar>
</template>

<script>
export default {};
</script>

<style scoped>
.header span {
  margin-left: 20px;
}
.header .gradient-primary {
  background-image: linear-gradient(
    -52deg,
    #fb6a49 0,
    #fc3579 29%,
    #241dba 100%
  );
  height: 6px;
  position: absolute;
  bottom: -6px;
  left: 0;
  right: 0;
}
</style>
