<template>
  <div class="mt-5 mb-5">
    <h1 class="text-center">Información y datos</h1>

    <section v-if="errored">
      <p>Lo sentimos, no es posible obtener la información en este momento, por favor intente nuevamente mas tarde</p>
    </section>

    <section v-else class="d-flex justify-center">
      <div v-if="loading">Cargando...</div>
      <div v-else>
        <template>
          <div>
            <v-data-table
              :headers="headers"
              :items="infoApi"
              item-key="id"
              class="elevation-1"
              :search="search"
              :custom-filter="filterText"
            >
              <template v-slot:top>
                <v-text-field v-model="search" label="Buscar" class="mx-4"></v-text-field>
              </template>
              <template v-slot:[`item.modified`]="{ item }">
                <span>{{ item.modified | moment }}</span>
              </template>
            </v-data-table>
          </div>
        </template>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";
import moment from "moment";

export default {
  name: "Table",
  data() {
    return {
      loading: true,
      errored: false,
      search: "",
      infoApi: [],
      headers: [
        {
          text: "ID",
          align: "start",
          value: "id",
        },
        { text: "Nombre", value: "name", align: "start" },
        { text: "Grupo de acceso", value: "access_group_name", align: "start" },
        { text: "Nombre de la sesión", value: "sessions[0].name", align: "start" },
        { text: "ID sesión", value: "sessions[0].id", align: "start" },
        {
          text: "Fecha de modificación",
          value: "modified",
          align: "center",
        },
      ],
    };
  },
  methods: {
    moment: function() {
      return moment();
    },
    filterText(value, search) {
      return value != null && search != null && typeof value === "string" && value.toString().indexOf(search) !== -1;
    },
  },
  filters: {
    moment: function(date) {
      return moment(date).format("MM/DD/YYYY - HH:mm");
    },
  },
  mounted() {
    const headers = { Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda=" };
    axios
      .get("https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1", { headers })
      .then((response) => {
        this.infoApi = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
};
</script>

<style lang="scss" scoped>
.div-container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
</style>
