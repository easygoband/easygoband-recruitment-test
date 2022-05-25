<template>
    <main>
        <div class="main-content">
            <div class="table-title">
                <h4>Table of Content</h4>
                <p>Use select menus to filter the data</p>
                <p>Data fetched from external source</p>
            </div>
            <data-container />
        </div>
    </main>
</template>

<script>
import DataContainer from '@/components/DataContainer.vue'
export default {
    name: 'AppMain',
    components: {
        DataContainer,
    },
}
</script>

<style scoped>
main {
    background-color: var(--main-bg);
}
.main-content {
    width: fit-content;
    margin: 0 auto;
    height: 100vh;
}
.table-title {
    padding: 20px 0;
}
</style>
