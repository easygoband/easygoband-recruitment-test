<template>
  <v-app  >    
    <v-main>
      <navbar/>
      <v-card>
    <v-card-title>
      <v-text-field
        v-model="search"
        label="Buscar"
        single-line
        hide-details      
      ></v-text-field>
       </v-card-title>
            <v-data-table      
            :headers="headers"
            :items="Object.values(save[0])"      
            :search="search"
    >     
    </v-data-table>    
  </v-card>  
    </v-main>
  </v-app>
</template>

<script>
import Navbar from './components/Navbar.vue'
import axios from "axios";
export default {
  name: 'App',

  components: {
    Navbar
  },

  data: () => ({
    save: [],
    index:0,
    search:'',
    headers: [
          {
            text: 'Nombre de grupo de accesso',
            align: 'start',
            value: 'access_group_name',
          },
          { text: 'Id del grupo de acceso', value: 'access_group_id'  , filterable: false},
          { text: 'Usos totales', value: 'total_uses'  , filterable: false},
          { text: 'Nombre Sesion', value: 'sessions[0].name', filterable:true},
          { text: 'Id Sesion', value: 'sessions[0].id' , filterable: false },
          { text: 'Id del evento', value: 'event_id' , filterable: false },
          { text: 'structure_decode', value: 'structure_decode' , filterable: false },
          { text: 'Nombre', value: 'name'  , filterable: false},
          { text: 'Modificado', value: 'modified'  , filterable: false},
          { text: 'Id', value: 'id'  , filterable: false},
          { text: 'Id del producto basico', value: 'basic_product_id'  , filterable: false},
          
        ]
    
  }),
  methods:{
    
     async getApi(){
      
      let webApiUrl = 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1'
      let tokenStr = 'Basic cJmAc71jah17sgqi1jqaksvaksda=';
      let save = await axios.get(webApiUrl, { headers: {"Authorization" : tokenStr} }).catch(function (error) {
  console.log(error);
})
      
      this.args= this.save
      console.log(save)
      this.save = Object.values(save)
      return this.save

}
    },
    
  created(){
    this.getApi()
    
  }
}
  
</script>
