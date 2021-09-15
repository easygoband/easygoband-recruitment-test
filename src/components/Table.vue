<template>
  <table>
    <thead>
      <tr class="bg-gray-100 border-b-2 border-gray-400">
        <th>ID</th>
        <th>
          <span>Name</span>
        </th>
        <th>Access Group Name</th>
        <th>Modified</th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="(a, index) in assets"
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

  props: {
    assets: {
      type: Array,
      default: () => [],
    },
  },
  methods: {
    getUpdateDate: function(date) {
      return moment(date, "YYYY-MM-DD").format("DD/MM/YYYY");
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
