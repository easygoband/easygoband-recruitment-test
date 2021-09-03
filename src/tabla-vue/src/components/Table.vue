<template>
  <div id="table" class="container">
    <div class="search-group">
      <input
        id="search-input"
        class="search-input"
        type="text"
        placeholder="Buscar"
        v-model="inputText"
        v-on:keyup.enter="filter"
      />
      <button id="search-btn" class="search-btn" @click="filter">
        <fa icon="search" style="color:white"></fa>
      </button>
    </div>
    <table>
      <thead>
        <tr>
          <th name="id" id="id" @click="sort($event)">ID</th>
          <th name="session" id="session" @click="sort($event)">Sesión</th>
          <th name="name" id="name" @click="sort($event)">Nombre</th>
          <th name="modified" id="modified" @click="sort($event)">Fecha modificación</th>
        </tr>
      </thead>
      <tbody>
        <!-- Recorre la array filtrada -->
        <tr :id="obj.id" v-bind:key="obj.id" v-for="obj in filteredFilms">
          <td>{{obj.id}}</td>
          <td>{{obj.sessions[0].name}}</td>
          <td>{{obj.name}}</td>
          <td>{{ obj.modified | formatDate}}</td>
        </tr>
      </tbody>
    </table>
    <h1 v-if="size==0" class="empty-message">No se ha encontrado ningún resultado :(</h1>
  </div>
</template>

<script>
import moment from "moment";
import IconDown from "./../assets/sort-down.svg";
import IconUp from "./../assets/sort-up.svg";

export default {
  name: "Table",
  components: {},
  mounted() {
    this.getData();
  },
  methods: {
    //Recoje la array de la api y actualiza el valor de la variable data a esta array
    async getData() {
      const response = await fetch(
        "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1",
        {
          method: "get",
          headers: new Headers({
            Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda="
          })
        }
      );
      const responseJson = await response.json();
      this.data = responseJson;
    },

    //Activa el filtro del input en el ID, Sesión y nombre
    filter() {
      this.filterText = this.inputText;
    },
    //ordenamos la columna seleccionada
    sort(event) {
      //este valor es el que se devuelve en la comparacion si el primer valor es mayor o igual.
      //pro ello si devolvemos un numero positivo se trata de un orden ascendente y si es negativo sera descendente
      var comparationValue = 1;

      var doSortDescending = false;

      //buscamos si existe una columna ya ordenada encontrando el icono de ordenación
      const actualIcon = document.querySelector(".sort-icon");

      if (event.target.contains(actualIcon)) {
        //si esta columna está ordenada debemos saber que tipo de orden es y hacer el contrario
        doSortDescending = ! (actualIcon.id=="down-icon")
          

        actualIcon.remove();

        //según devuelva un valor positivo o negativo al comparar los valores será descendente o ascendente
        comparationValue = doSortDescending ? 1 : -1;
      } else {
        //si no está ordenada esta columna eliminamos el icono si existia de la
        //columan que anteriormente lo tuviera
        if (actualIcon) actualIcon.remove();
        //y en este caso seria una ordenación de tipo ascendente por lo que dejamos el valor del principio como 1
        doSortDescending = true;
      }

      //logica de la ordenación en este caso al tener sesion como un atributo
      // dentro de un objeto no podemos acceder usando el id del th
      if (event.target.id == "session")
        this.data.sort((a, b) =>
          a.sessions[0].name >= b.sessions[0].name
            ? comparationValue
            : comparationValue * -1
        );
      else
        this.data.sort((a, b) =>
          a[event.target.id] >= b[event.target.id]
            ? comparationValue
            : comparationValue * -1
        );
      this.addSortIcon(event.target, doSortDescending);
    },
    addSortIcon(column, isDescendent) {
      const iconSvg = isDescendent ? IconDown : IconUp;
      const icon = document.createElement("img");
      icon.setAttribute("src", iconSvg);
      icon.setAttribute("id", isDescendent ? "down-icon" :"up-icon" );
      icon.classList.add("sort-icon");

      column.appendChild(icon);
    }
  },
  computed: {
    //Devuleve la array filtrada por el input
    filteredFilms() {
      let filter = new RegExp(this.filterText, "i");
      const filtered = this.data.filter(
        el =>
          el.sessions[0].name.match(filter) ||
          el.name.match(filter) ||
          el.id.toString().match(filter)
      );
      return filtered;
    }
  },
  watch: {
    filteredFilms(newValue) {
      this.size = newValue.length;
    }
  },
  data() {
    return {
      data: [],
      inputText: "",
      filterText: "",
      size: 0
    };
  },
  filters: {
    // Cambia el formato de la fecha
    formatDate: function(value) {
      if (value) {
        return moment(String(value)).format("MM/DD/YYYY hh:mm");
      }
    }
  }
};
</script>

