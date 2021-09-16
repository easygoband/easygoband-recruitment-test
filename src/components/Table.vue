<template>
  <table>
    <thead>
      <tr class="bg-gray-100 border-b-2 border-gray-400">
        <th>ID</th>
        <th :class="{ up: this.sortOrder === 1, down: this.sortOrder === -1 }">
          <span class="underline cursor-pointer" @click="changeSortOrder"
            >Name</span
          >
        </th>
        <th>Access Group Name</th>
        <th>Modified</th>
        <td class="hidden sm:block">
          <input
            class="bg-gray-100 focus:outline-none border-b border-gray-400 py-2 px-4 block w-full appearance-none leading-normal"
            id="filter"
            placeholder="Buscar..."
            type="text"
            v-model="filter"
          />
        </td>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="(a, index) in filteredAssets"
        :key="index"
        class="border-b border-gray-200 hover:bg-gray-100 hover:bg-orange-100"
      >
        <td>#{{ a.id }}</td>
        <td>{{ a.name }}</td>
        <td>{{ a.access_group_name }}</td>
        <td>{{ getUpdateDate(a.modified) }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import moment from "moment";

export default {
  name: "Table",

  data() {
    return {
      filter: "",
      sortOrder: 1,
    };
  },

  props: {
    assets: {
      type: Array,
      default: () => [],
    },
  },
  computed: {
    filteredAssets() {
      const altOrder = this.sortOrder === 1 ? -1 : 1;
      return this.assets
        .filter(
          (a) =>
            a.access_group_name
              .toLowerCase()
              .includes(this.filter.toLowerCase()) ||
            a.name.toLowerCase().includes(this.filter.toLowerCase()) ||
            a.id.toLocaleString().includes(this.filter.toLowerCase())
        )
        .sort((a, b) => {
          if (parseInt(a.name) > parseInt(b.name)) {
            return this.sortOrder;
          }
          return altOrder;
        });
    },
  },
  methods: {
    getUpdateDate: function(date) {
      return moment(date, "YYYY-MM-DD").format("DD/MM/YYYY");
    },

    changeSortOrder() {
      this.sortOrder = this.sortOrder === 1 ? -1 : 1;
    },
  },
};
</script>

<style scoped>
.up::before {
  content: "👆";
}

.down::before {
  content: "👇";
}

td {
  padding: 20px 0px;
  font-size: 0.6rem;
  text-align: center;
}

th {
  padding: 5px;
  font-size: 0.6rem;
}

@media (min-width: 640px) {
  td,
  th {
    padding: 20px;
    font-size: 1rem;
  }

  th {
    padding: 12px;
  }
}
</style>
