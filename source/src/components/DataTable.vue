<template>
    <div class="table-container">
        <div class="filters">
            <label>
                <span><i class="bi bi-filter"></i></span>
                Filter By:
            </label>
            <div class="menus">
                <select-menu
                    v-for="(val, key, id) in tableFilters" :key="id"
                    :options="tableFilters[key]"
                    :placeholder="fixName(key)"
                    @selection="(arg) => setFilter(key, arg)" ref="menu"/>
                <button @click="resetFilters">Clear Filters</button>
            </div> 
        </div>
        <table>
            <thead>
                <tr>
                    <th v-for="(v, k, i) in entries[0]" :key="i" >
                        {{ fixName(k) }}
                        <span @click="sortData(k)" :class="'arrow ' + (reverse ? 'up' : 'down')"></span>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(value, key, index) in trimTable" :key="index">
                    <td v-for="(v, k, i) in value" :key="i" >
                        {{ v }}
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="pagination">
            <p>Pages</p>
            <div class="page-btns">
                <button @click="prevPage">prev</button>
                <p>{{ this.page }} / {{ this.getPages }}</p>
                <button @click="nextPage">next</button>
            </div>
        </div>
        <message-box mode="info" v-show="getPages === 0">
            <p>No matching entries for selected filters</p>
            <p>Please try others</p>
        </message-box>
    </div>
</template>

<script>
import SelectMenu from '@/components/SelectMenu.vue'
import MessageBox from '@/components/MessageBox.vue'
import { filtersFill } from '@/utils/Helper.js'

export default {
    name: 'DataTable',
    props: {
        tableDatas: {
            type: Object,
            default: () => {},
        },
        tableFilters: {
            type: Object,
            defualt: () => {},
        },
    },
    components: {
        SelectMenu,
        MessageBox,
    },
    data: function() {
        return {
            from: 0,
            maxEntries: 10,
            page: 1,
            filters: {},
            entries: [],
            reverse: false,
        };
    },
    mounted: function() {
        Object.keys(this.tableFilters).forEach(filter => {
            this.$set(this.filters, filter, '');
        })
        this.entries = this.tableDatas;
    },
    computed: {
        rowsCount() {
            let rows = Object.keys(this.filterData).length;
            if(rows) {
                return rows;
            }
            return 0;
        },
        getPages() {
            let count = this.rowsCount
            let remain = count - (count % this.maxEntries)
            let pages = remain / this.maxEntries
            return count % this.maxEntries > 0 ? pages + 1 : pages
        },
        to() {
            let range = this.rowsCount
            let end = this.page * this.maxEntries
            return range === range % end ? range : end
        },
        filterData() {
            let datas = Object.values(this.entries);
            if(filtersFill(this.filters) > 0) {
                datas = datas.filter(data => {
                    let coincidences = 0;
                    for(const filter in this.filters) {
                        coincidences += (data[filter] == this.filters[filter])
                    }
                    return coincidences === filtersFill(this.filters);
                })
            }
            return datas;
        },
        trimTable() {
            let arr = this.filterData;
            let trimedTable = arr.slice(this.from, this.to);
            if(trimedTable.length < this.maxEntries) {
                let empties = this.maxEntries - trimedTable.length;
                trimedTable = trimedTable.concat( new Array(empties).fill({}) );
            }
            return Object.assign({}, [...trimedTable]);
        },
    },
    methods: {
        prevPage() {
            if(this.page > 1) {
                this.page--;
                this.from -= this.maxEntries;
            }
        },
        nextPage() {
            if(this.page < this.getPages) {
                this.page++;
                this.from += this.maxEntries;
            }
        },
        setFilter(key, value) {
            this.filters[key] = value;
        },
        resetFilters() {
            if(filtersFill(this.filters) > 0) {
                for(const filter in this.filters) {
                    this.filters[filter] = '';
                }
            }
            this.$refs.menu.forEach(m => m.resetMenu());
        },
        sortData(key) {
            this.reverse = !this.reverse;
            let datas = Object.values(this.entries);
            if(this.reverse) {
                datas.sort((dataA, dataB) => {
                    return dataA[key] > dataB[key];
                });
            } else {
                datas.reverse();
            }
            this.entries = Object.assign({}, [...datas]);
        },
        fixName(name) {
            return name.replace(/_/g, ' ');
        },
    },
    watch: {
        filters: {
            handler() {
                this.page = 1;
                this.from = 0;
            }, 
            deep: true,
        },
    },
}
</script>

<style>
.table-container {
    position: relative;
}
.filters {
    background-color: var(--primary-green-bg);
    color: var(--secondary-green-fg);
    display: flex;
    align-items: center;
    padding: 10px;
}
.menus {
    display: flex;
}
.menus > button {
    border: none;
    width: 100px;
    margin: 0px 5px;
}
table {
    background-color: var(--light-blue-bg);
    color: var(--primary-blue-bg);
    width: 1000px;
    border-collapse: collapse;
}
tbody > tr:nth-child(even) {
    background-color: var(--secondary-blue-bg);
}
tr {
    height: 30px;
    /*display: flex;
    justify-content: space-around;*/
}
tr > th, tr > td {
    text-align: center;
    /*flex: 1;*/
    line-height: 25px;
}
th {
    background-color: var(--primary-blue-bg);
    color: var(--light-blue-bg);
    text-transform: capitalize;
}
.down {
    border-top: 6px solid var(--light-blue-bg);
}
.up {
    border-bottom: 6px solid var(light-blue-bg);
}
.arrow {
    width: 0;
    height: 0;
    border-left: 6px solid transparent;
    border-right: 6px solid transparent;
    display: inline-block;
    margin: 2px;
}
.pagination {
    background-color: var(--secondary-green-fg);
    color: var(--primary-green-bg);
    padding: 10px;
    text-align: center;
}
.page-btns {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 40%;
    margin: 0 auto;
}
.page-btns > button {
    border: none;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    background-color: var(--primary-green-bg);
    color: #ccfff3;
    cursor: pointer;
}
</style>
