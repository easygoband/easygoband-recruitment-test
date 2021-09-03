// Import the `mount()` method from Vue Test Utils
import { mount } from '@vue/test-utils'
import Table from '@/components/Table.vue'
import flushPromises from 'flush-promises'
import Vue from 'vue'

global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve([
    {
      "access_group_name": "Jueves",
      "access_group_id": 6,
      "total_uses": 0,
      "sessions": [
        {
          "name": "02-JUEVES",
          "id": 20
        }
      ],
      "event_id": 1,
      "structure_decode": false,
      "name": "TKT CE JUEVES MR 70",
      "modified": "2017-05-30T17:42:27.000Z",
      "id": 82,
      "basic_product_id": 28
    },{
      "access_group_name": "Abono",
      "access_group_id": 1,
      "total_uses": 0,
      "sessions": [
        {
          "name": "01-ABONO",
          "id": 19
        }
      ],
      "event_id": 1,
      "structure_decode": false,
      "name": "TKT CE ABONO 95",
      "modified": "2017-05-30T17:42:27.000Z",
      "id": 78,
      "basic_product_id": 27
    }
    ]),
  })
);



test('Muestra los datos', async () => {


  // mount() returns a wrapped Vue component we can interact with
  const wrapper = mount(Table)

  await flushPromises()
 
  const rows = wrapper.find('tbody > tr')
 
  // Comprueba que se muestra la fila
  expect(rows.exists()).toBe(true);

})

test('Los ordena descandentemente por id', async () => {


  // mount() returns a wrapped Vue component we can interact with
  const wrapper = mount(Table)
  

  await flushPromises()
 
  const id = wrapper.find('#id')
  id.trigger('click')
  await Vue.nextTick()
  

  // Comprueba que se muestra la fila
  expect(wrapper.find('tbody > tr:last-of-type').attributes().id).toBe("82");

})

