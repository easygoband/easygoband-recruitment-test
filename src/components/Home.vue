<template>
  <div>
    <link href="https://cdn.jsdelivr.net/npm/@mdi/font@5.x/css/materialdesignicons.min.css" rel="stylesheet">

    <v-app-bar 
      dark 
      fixed
      hide-on-scroll
      >
      <v-menu
        left
        bottom
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-menu</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item
            v-for="(navOption, index) in navOptions"
            :key="index"
            @click="navOption.onClick"
          >
            <v-list-item-title>{{navOption.text}}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <v-toolbar-title>Entradas</v-toolbar-title>
      <v-spacer/>
      <input class="searchbar" @input="updateNameFilter" placeholder="Buscar">
      <v-btn icon @click="focusSearchbar">
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
    </v-app-bar>


    <p class="tkt-results">{{getFilteredTickets?getFilteredTickets.length:0}} resultados</p>
    
    <v-container 
      v-if="showAdvancedSearch"
      class="mt-3"
      >
      <v-row class="d-flex justify-space-around">
        <v-menu 
        close-on-click
        close-on-content-click
        max-height="90%"
        v-for="advancedSearchOption in advancedSearchOptions" 
        :key="advancedSearchOption.name"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              v-bind="attrs"
              v-on="on"
            >
              {{advancedSearchOption.text}}
            </v-btn>
          </template>
          <v-list scroll>
            <v-list-item
              v-for="(item, index) in advancedSearchOption.list"
              :key="index"
              @click="advancedSearchOption.onClick"
            >
              <v-list-item-title>{{ item.value }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-btn 
          fab 
          small 
          class="red lighten-1"
          @click="resetAdvancedSearch"
          >
          <v-icon small>mdi-reload</v-icon>
        </v-btn>

        <v-btn 
          fab 
          small 
          class="red lighten-1"
          @click="closeAdvancedSearch"
          >
          <v-icon small>mdi-close</v-icon>
        </v-btn>

      </v-row>
    </v-container>



    <v-container v-if="isLoaded()&&getFilteredTickets.length">
      <v-row class="d-flex flex-wrap justify-space-around">
        <v-col
        v-for="ticket of getFilteredTickets" 
        :key="ticket.id" 
        cols="12" xs="11" sm="5" md="5" lg="3" xl="2"
        class="tkt-wrapper">

          <p class="tkt-title">{{ticket.name}}</p>

          <table>
            <td>
              <tr>Grupo</tr>
              <tr>{{ticket.access_group_name}}</tr>
            </td>
            <td>
              <tr>Usos</tr>
              <tr>{{ticket.total_uses}}</tr>
            </td>
          </table>

          <p class="time-ago" v-html="parseDate(ticket.modified)"></p>
        
        </v-col>
      </v-row>
    </v-container>
    <v-container v-else-if="isLoading()">Cargando</v-container>
    <v-container v-else>No se ha encontrado ninguna entrada.</v-container>
  </div>
</template>



<script>
import {timeSince} from "../lib/helpers/timeSince.js"

export default {
  name: 'Home',
  props: [
    "tickets", 
    "filterOptions", 
    "navOptions", 
    "showAdvancedSearch", 
    "advancedSearchOptions",
    "resetAdvancedSearch",
    "closeAdvancedSearch"
    ],
  methods: {
    isLoaded(){return this.tickets&&this.tickets.length},
    isLoading(){return this.tickets?false:true},
    parseDate(date) {
      return "Actualizado hace "+timeSince(Date.parse(date))
    },
    updateNameFilter(e){
      this.filterOptions.name=e.target.value
    },
    updateUseFilter(e){
      this.filterOptions.use=e
    },
    focusSearchbar(){
      document.querySelector(".searchbar").focus()
    }
  },
  computed:{
    getFilteredTickets(){
      if(this.tickets&&this.tickets.length){
        return this.tickets.filter(ticket=>{
          let result = true
          Object.keys(this.filterOptions).forEach(option=>{
            if(option==="name"){
              if(!ticket.name.toLowerCase().includes(this.filterOptions[option].toLowerCase())){
                result=false
              }
            }
            else {
              if(this.filterOptions[option]!==null){
                if(ticket[option]!==this.filterOptions[option]){result=false}
              }
            }
          });
          return result
        }
          
        )
      } return null
    }
  }
}
</script>

<style scoped>

  .searchbar {
    height: inherit;
    width: 27%;
    color: white;
    padding-left:20px;
    margin-right:5px;
  } 

  .searchbar:focus{
    background-color: #2c2c2cbd;
    outline-width: 0;
  }

  .tkt-results{
    font-size: .9em;
    margin-top: 75px;
    text-align: center;
  }

  .tkt-wrapper {
    margin: 20px 10px;
    padding: 15px;
    border: solid gray 1px;
    border-radius: 5px;
    -webkit-box-shadow: 0px 0px 8px 3px rgba(230,230,230,1);
    -moz-box-shadow: 0px 0px 8px 3px rgba(230,230,230,1);
    box-shadow: 0px 0px 8px 3px rgba(230,230,230,1);
    background-color: #f1f1f1;
  }
  
  table{
    margin: 15px 0;
    display: flex;
    justify-content: space-around;
    text-align: center;
    line-height: 1.5;
  }


  table td tr:nth-of-type(1){
    font-size: .9em;
  }

  table td tr:nth-of-type(2){
    font-weight: 600;
  }

  .time-ago {
    text-align: right;
    font-size: .8em;
  }
</style>
