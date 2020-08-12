<template>
  <v-app>
    <!-- !!! Should use router-view inside v-main passing prop tickets-->
    <Home 
    v-bind:tickets="tickets" 
    v-bind:filteredTickets="filteredTickets" 
    v-bind:filterOptions="filterOptions" 
    v-bind:navOptions="navOptions" 
    v-bind:showAdvancedSearch="showAdvancedSearch"
    v-bind:advancedSearchOptions="advancedSearchOptions"
    v-bind:resetAdvancedSearch="resetAdvancedSearch"
    v-bind:closeAdvancedSearch="closeAdvancedSearch"
    />
  </v-app>
</template>

<script>
import Home from './components/Home.vue'

import ticketService from "./lib/services/ticket-service.js"

export default {
  name: 'App',
  components: {
    Home
  }, 
  data(){
    return {
      tickets: null,
      navOptions:[
        {
          name: "showAdvancedSearch",
          text: "Advanced Search",
          onClick: ()=>{this.showAdvancedSearch=!this.showAdvancedSearch
          }
        }
      ],
      showAdvancedSearch: false,
      advancedSearchOptions: [
        {
          name: "total_uses",
          text: "Usos",
          getFunc:"getAllUses",
          list: [],
          onClick:(e=>{this.filterOptions.total_uses = parseInt(e.target.textContent)})
        },{
          name: "access_group_name",
          text: "Grupo",
          getFunc:"getFilteredTickets",
          list:[],
          onClick:(e=>{this.filterOptions.access_group_name = e.target.textContent})
        }
      ],
      filteredTickets: null,
      filterOptions:{
        name:"",        
        total_uses: null,
        access_group_name: null
      },
      findAllAdvancedSearchLists: ()=>{
        this.advancedSearchOptions.find(option=>option.name==="total_uses").list=this.getAllDifferentValues("total_uses")
        this.advancedSearchOptions.find(option=>option.name==="access_group_name").list=this.getAllDifferentValues("access_group_name")
      },
      resetAdvancedSearch:()=>{
        Object.keys(this.filterOptions).forEach(option=>{
          if(option!=="name"){
            this.filterOptions[option]=null
          }
        })
      },
      closeAdvancedSearch:()=>{
        this.showAdvancedSearch = false;
        this.resetAdvancedSearch()
      },
      getAllDifferentValues: (propName)=>{
        if(this.tickets&&this.tickets.length){
          const allDifferentValues=[]
          this.tickets.forEach(ticket=>{
            if(allDifferentValues.includes(ticket[propName])){
              return false
            } 
            allDifferentValues.push(ticket[propName]);
          })
          return allDifferentValues.map(value=>{
            return {
              value: value,
              onClick:()=>{this.filterOptions[propName]=value}
            }
          })
        } return null
      }
    }
  },
  async created(){
    this.tickets = await ticketService.getTickets()
    this.findAllAdvancedSearchLists()
  }
}
</script>

<style>
/* GLOBAL STYLES */
#app {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
#app p {
  margin-bottom: 0
}
/* CSS RESET */
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
</style>
