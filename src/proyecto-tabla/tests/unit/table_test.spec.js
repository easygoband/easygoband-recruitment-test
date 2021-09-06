import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import Table from '@/components/Table.vue'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vue from 'vue'
Vue.use(BootstrapVue)

describe('Table.vue unit tests', () => {
	let wrapper;

	beforeEach(() => {
		wrapper = shallowMount(Table)
	})

	it('Renders',() => {
		expect(wrapper.exists()).equal(true);
	})

	it('Se muestra el titulo',() => {
		expect(wrapper.find("h1").text()).equal("Tabla Proveedores");
	})
})