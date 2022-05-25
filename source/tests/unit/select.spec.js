import { mount } from '@vue/test-utils'
import Vue from 'vue'
Vue.directive('outside-click', {})
import SelectMenu from '@/components/SelectMenu.vue'

const games = ['halo 1', 'halo 2', 'halo 3']

const wrapper = mount(SelectMenu, {
    propsData: {
        options: games,
    }
})

describe('Testing select menu options', () => {
    test('Should be an Array', () => {
        expect(wrapper.props().options).toEqual(games);
    })
    const options = wrapper.findAll('.option')
    test('Should render a list of length of option prop length', () => {
        expect(options.length).toBe(games.length);
    })
    test('Value should same as option clicked', async () => {
        await options.wrappers[1].trigger('click');
        expect(wrapper.text()).toContain('halo 2')
    })
})
