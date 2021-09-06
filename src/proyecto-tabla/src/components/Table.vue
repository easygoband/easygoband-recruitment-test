<template>
  <div class="main-container">
		<div style="padding-top: 50px;" class="col">
			<h1>Tabla Proveedores</h1>
		</div>
		<div style="padding-top: 50px; padding-bottom: 50px" class="row h-100 justify-content-center align-items-center">
        	<div class="col-10 col-md-8 col-lg-6">
				<b-form-group>
					<b-input-group size="sm">
						<b-form-input
							id="filter-input"
							v-model="filter"
							type="search"
							placeholder="Escribe aqui lo que quieras buscar..."
						>
						</b-form-input>
							<b-input-group-append>
							<b-button :disabled="!filter" @click="filter = ''">Borrar</b-button>
						</b-input-group-append>
					</b-input-group>
				</b-form-group>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col">
				<b-table id="table" :items="items" :fields="fields"
				:filter="filter"
				label-sort-asc label-sort-desc 
				striped small
				:per-page="perPage" :current-page="currentPage" 
				responsive="sm"> 
				</b-table>
			</div>
		</div>

		<b-pagination 
		class=" justify-content-center align-items-center"
			v-model="currentPage"
			:total-rows="items.length"
			aria-controls="my-table"
		></b-pagination>
  	</div>
</template>

<script>
import Servicio_API from '../services/API';
import moment from "moment";

  export default {
    data() {
      	return {
			filter: null,
			perPage: 10,
			currentPage: 1,
			fields: [{ key: 'id', 					sortable: true },
					{ key: 'nombre', 				sortable: true },
					{ key: 'fecha_modificacion', 	sortable: true },
					{ key: 'nombre_grupo', 			sortable: true }],
			items: [],
			api : new Servicio_API()
      	}
    },
    
	beforeMount: function() {
        this.api.obtainData().then((response)=>{
            response.forEach((dato)=>{
                var fecha = moment(String(dato.modified)).format("MM/DD/YYYY hh:mm")

                this.items.push({ 
                    "id"                  : dato.id,
                    "nombre"              : dato.name,
                    "fecha_modificacion"  : fecha,
                    "nombre_grupo"        : dato.access_group_name,
                });
            })
        })
    },
  }
</script>