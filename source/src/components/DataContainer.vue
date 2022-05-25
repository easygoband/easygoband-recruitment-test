<template>
    <div class="wrapper">
        <load-spinner v-if="loading === true" />
        <data-table v-if="dataIsReady" :tableDatas="tdata" :tableFilters="tfilters"/>
    </div>
</template>

<script>
import DataTable from '@/components/DataTable.vue'
import LoadSpinner from '@/components/Spinner.vue'
import { mapData, mapFilters } from '@/utils/Helper.js'
import getData from '@/utils/api.js'

export default {
    name: 'DataContainer',
    components: {
        DataTable,
        LoadSpinner,
    },
    data: function() {
        return {
            tdata: {},
            tfilters: {},
            loading: false,
        };
    },
    created: function() {
        this.getTableData();
    },
    methods: {
        getTableData() {
            this.loading = true;
            getData(process.env.VUE_APP_API_URL, process.env.VUE_APP_API_AUTH_KEY)
            .then(result => result.json()).then(datas => {
                // Get the data and choose which columns to display
                this.tdata = mapData(datas, td => {
                    return {
                        id: td.id,
                        name: td.name,
                        session_name: td.sessions[0].name,
                        session_id: td.sessions[0].id,
                        group_name: td.access_group_name,
                        group_id: td.access_group_id,
                        modified: td.modified.substring(0, 10) + " " + td.modified.substring(11, 16),
                    };
                });
                // Choose what filters to use
                this.tfilters = mapFilters(datas, filter => {
                    return {
                        session_name: filter.sessions[0].name,
                        group_name: filter.access_group_name,
                    }
                });
            }).finally(() => this.loading = false);
        },
    },
    computed: {
        dataIsReady() {
            return Object.keys(this.tdata).length;
        },
    }
}
</script>

<style scoped>
</style>
