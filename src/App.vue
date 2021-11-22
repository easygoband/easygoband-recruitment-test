<template>
  <div id="app">
    <EasyGoTable :items="events" :header="header" />
  </div>
</template>

<script>
import EasyGoTable from './components/EasyGoTable.vue'
import { getEvents } from './services/events.service'

export default {
  name: 'App',
  components: {
    EasyGoTable
  },
  data: function () {
    return {
      events: [],
      header: {
        access_group_name: 'Nombre Grupo',
        access_group_id: 'Id Grupo',
        sessions: 'Sesión',
        event_id: 'Id Evento',
        structure_decode: 'Decodificado',
        name: 'Nombre',
        modified: 'Modificado',
        id: 'Id',
        basic_product_id: 'Id producto',
        total_uses: 'Usos totales'
      }
    }
  },
  beforeCreate: async function () {
    const data = await getEvents()
    this.events = data.map((item) => {
      return { ...item, sessions: item.sessions[0].name }
    })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
