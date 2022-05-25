<template>
    <div class="select-menu">
        <div class="select" ref="select" @click="toggleOptions" v-outside-click="closeMenus">
           {{ value }}
        </div>
        <div class="options hide" ref="options">
            <div class="option" v-for="option in options" :key="option" 
            ref="option" @click.stop="setValue">
                {{ option }}
            </div>
        </div>
    </div> 
</template>

<script>
export default {
    name: 'SelectMenu',
    props: {
        options: {
            type: Array,
            default: () => []
        },
        placeholder: {
            type: String,
            default: () => ''
        },
    },
    data: function() {
        return {
            value: '',
        };
    },
    mounted: function() {
        this.value = this.placeholder;
    },
    methods: {
        deselect() {
            this.$refs.option.forEach(opt => {
                if(opt.classList.contains('selected')) {
                    opt.classList.remove('selected');
                }
            });
        },
        setValue(event) {
            this.deselect();
            event.target.classList.add('selected');
            this.value = event.target.innerText;
            this.$refs.options.classList.add('hide');
            this.$emit('selection', this.value);
        },
        hideOthersOptions(el) {
            //TODO: Maybe put this in Helper.js
            const menus = document.getElementsByClassName('select');
            for(let i = 0; i < menus.length; i++) {
                if(menus[i] !== el) {
                    menus[i].nextSibling.classList.add('hide');
                }
            }
        },
        toggleOptions(event) {
            this.hideOthersOptions(event.target);
            this.$refs.options.classList.toggle('hide');
        },
        closeMenus(event) {
            this.hideOthersOptions(event.target);
        },
        resetMenu() {
            this.deselect();
            this.value = this.placeholder;
        },
    },
}
</script>

<style scoped>
.select-menu {
    position: relative;
    background-color: var(--secondary-green-bg);
    cursor: pointer;
    margin: 0 5px;
}
.select {
    text-transform: capitalize;
}
.select, .option {
    padding: 5px;
    width: 200px;
}
.options {
    position: absolute;
    background-color: var(--secondary-green-bg);
    z-index: 10000;
    overflow: scroll;
    height: 400px;
}
.option:hover {
    background-color: var(--primary-green-bg);
}
.selected {
    background-color: var(--primary-green-bg);
}
.hide {
    display: none;
}
</style>
