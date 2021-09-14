/**
 * @author DAN NEDELEA
 * TEST PRUEBA EASYGOBAND
 */

import axios from "axios";

// PLUGIN DE JQUERY PARA LA CREACIÓN DE TABLAS
// EL IMPORT DE DATATABLES LO DETECTA COMO ERROR POR ALGUNA RAZON, POR LO QUE DESACTIVAMOS ESLINT
/* eslint-disable */
import datatable from "datatables.net-bs4";
/* eslint-enable */

import $ from "jquery";

// PLUGIN PARA FORMATEAR LA FECHA
import moment from "moment";

export default {
  mounted() {
    this.getDataApi();
  },

  data() {
    return {
      data: [],
    };
  },

  methods: {
    tabla() {
      // INTRODUCIR DATOS A LA TABLA
      this.$nextTick(() => {
        $("#table").DataTable();
      });
    },

    moment: function() {
      return moment();
    },

    getDataApi() {
      // EXTRAEMOS LOS DATOS DE LA API
      axios
        .get(
          "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1",
          { headers: { Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda=" } }
        )
        .then((res) => {
          this.data = res.data;
          this.tabla();
        });
    },
  },

  filters: {
    moment(value) {
      // FILTRO PARA EL FORMATO DE FECHA
      if (value) {
        return moment(value).format("MM/DD/YYYY - hh:mm");
      }
    },
  },
};
