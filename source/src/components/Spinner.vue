<template>
    <div class="loader"></div>
</template>

<script>
export default {
    name: 'LoadSpinner',
}
</script>

<style scoped>
.loader {
    border-radius: 50%;
    width: 7em;
    height: 7em;
    border-top: 1em solid transparent;
    border-right: 1em solid transparent;
    border-bottom: 1em solid transparent;
    border-left: 1em solid var(--primary-green-bg);
    animation: load 1.1s infinite linear;
    margin: 0 auto;
}
@keyframes load {
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
</style>
