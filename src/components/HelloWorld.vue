<template>
  <div class="container">
    <div v-for="row in info" :key="row.id">
      <p>{{row.name}}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'HelloWorld',
  data () {
    return {
      info: []
    }
  },
  mounted () {
    axios
      .get('https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1', {
        headers:{
          "Authorization": "Basic cJmAc71jah17sgqi1jqaksvaksda="
        }
      })
      .then(response => (this.info = response.data))
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
