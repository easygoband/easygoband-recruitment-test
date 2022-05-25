import { shallowMount } from '@vue/test-utils'
import DataTable from '@/components/DataTable.vue'

const datas = [
    { name: 'halo ce', year: 2001 },
    { name: 'halo 2', year: 2004 },
    { name: 'halo 3', year: 2007 },
    { name: 'halo odst', year: 2009 },
    { name: 'halo reach', year: 2010 }
]

let games = Object.assign({}, [...datas]);
let filters = {
    name: ['halo ce','halo 2','halo 3','halo odst','halo reach'],
    year: [2001, 2004, 2007, 2009, 2010],
}

const wrapper = shallowMount(DataTable, {
    propsData: {
        tableDatas: games,
        tableFilters: filters
    }
})

describe('Test table functionlity', () => {
    test('Table props should be valid', () => {
        expect(wrapper.props().tableDatas).toEqual(games)
        expect(wrapper.props().tableFilters).toEqual(filters);
    })
    test('table page length should be the same as maxEntries', () => {
        let entries = Object.values(wrapper.vm.trimTable);
        expect(entries.length).toBe(wrapper.vm.$data.maxEntries);
    })
    test('Pages count should be 1', () => {
        expect(wrapper.vm.getPages).toBe(1);       
    })
})
