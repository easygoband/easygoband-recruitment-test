
<template>

  <div class="main-container">
    
    <h1>Tabla Eventos Easygoband</h1>
    <div class="text-center pt-2" >
      <v-btn
        color="secundary"
        class="mr-2"
        
        

        @click="toggleOrder"
      >
        Cambiar orden tabla
      </v-btn>
      <v-btn
        color="secundary"
        class="mr-2"
        @click="nextSort"
        
      >
        Orden siguiente columna
      </v-btn>
    </div>
    <v-text-field
          v-model="search"
          label="Buscar por nombre (afectan mayus)"
          class="mx-4"
        ></v-text-field>
    <v-data-table
    
      :headers="headers"
      :items="info"
      :sort-by.sync="sortBy"
      :sort-desc.sync="sortDesc"
      class="elevation-2"
      :items-per-page="-1"
      :search="search"
      :custom-filter="filterOnlyCapsText"
    ></v-data-table>
    
        
      

      
  </div>
</template>


<script>
import axios from "axios";
import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.use(Vuetify)





  
  const searchByName = (item, term) => {
    if (term) {
      return this.items.filter(item => toLower(item).includes(toLower(term)))
    }

    return this.items
    
  }



export default {
  name: "HelloWorld",
  data() {
    return {
      headers: [
        {
          text: 'Id',
          align: 'start',
          value: 'id',
        },
        {
          text: 'Nombre',
          value: 'name',
        },
        {
          text: 'Grupo encargado',
          value: 'access_group_name',
        }

      ],
      info: [
        
      ],
      search: null,
      searched: [],
      sortDesc: false,
      sortBy:"id"
    };
  },
  mounted() {
    axios
      .get(
        "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1",
        {
          headers: {
            Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda="
          }
        }
      )
      .then(response => (this.info = response.data));
  },
  
  methods:{

    searchOnTable () {
        
        this.searched = searchByName(this.info.name, this.search);
        console.log("diste click buscar");
        console.log(this.info.name);
        console.log(this.search);
      },
    toggleOrder () {
      this.sortDesc = !this.sortDesc
    },
    nextSort () {
      let index = this.headers.findIndex(h => h.value === this.sortBy)
      index = (index + 1) % this.headers.length
      this.sortBy = this.headers[index].value
    },
    filterOnlyCapsText (value, search, item) {
        return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().toLocaleUpperCase().indexOf(search) !== -1
      },
    
  }
}

/*<th>Id </th><th>Nombre

                  <input type="text" v-model="search" placeholder="buscar" /> 
                    <button @click="searchOnTable">buscar</button>
                  
                </th>
                <th>Grupo encargado 
                    <input type="text" v-model="search1" placeholder="buscar"/>
                    <button @click="searchOnTable1">buscar</button> 
                
                </th>*/
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body{
  background-color: #CBBFD9;
  
  
  
}
main-container{
  margin: 150px auto;
  width: 600px;
  
}
table{
  margin-top: 10px;
  width: 80%;
  text-align:center;  
  background-color:#ffffff ;
  border-collapse: collapse;
  
  
}
th, td{
  border: solid 1px #93BFBB;
  padding:20;
  
  
  }
  td{
    text-align: left;
    align-items: right;
    font-family: 'arial';
    font-size: 15px;
  }
  thead{
  
  background-color: #030640;
  height: 40px;
  color: #F1F2C4;
  
  
}

tr{
  text-align:center;
  font-family: 'Times New Roman', Times, serif; 
  font-size: 20px;
  
}
tr:hover td{
  background-color: #f7f6e4;
  color: #020533;
  
}
input{
  margin-left: 100px;

}
h1{
  margin: 40px;
}




</style>
