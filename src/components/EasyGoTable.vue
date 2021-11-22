<script>
import Vue from 'vue'

export default {
  name: 'EasyGoTable',
  props: {
    items: Array,
    header: Object
  },
  data: function () {
    return {
      orderObj: {
        isAsc: true,
        item: ''
      },
      myItems: [...this.items],
      visibleItems: Object.keys(this.header)
    }
  },
  computed: {
    fields: function () {
      return Object.keys(this.header)
    },
    searchedItems: function () {
      const obj = {}
      for (const key in this.header) {
        obj[key] = ''
      }
      return obj
    }
  },
  watch: {
    items: function (newEl, oldEl) {
      this.myItems = [...newEl]
    }
  },
  methods: {
    search: function (prop, event) {
      Vue.set(this.searchedItems, prop, event.target.value)
      this.myItems = Object.values(this.searchedItems).every(cVal => cVal === '') ? [...this.items] : this.items.filter(this.searchObjects)
    },
    orderItem: function (itemHeader) {
      this.orderObj.isAsc = this.orderObj.item === itemHeader ? !this.orderObj.isAsc : false
      this.orderObj.item = itemHeader
      this.myItems = this.myItems.sort((a, b) => {
        if (a[itemHeader] > b[itemHeader]) {
          return this.orderObj.isAsc ? 1 : -1
        }
        if (a[itemHeader] < b[itemHeader]) {
          return this.orderObj.isAsc ? -1 : 1
        }
        return 0
      })
    },
    searchObjects: function (item) {
      for (const [key, value] of Object.entries(item)) {
        if (this.searchedItems[key] !== '') {
          const valueString = value.toString().toLowerCase()
          if (!valueString.includes(this.searchedItems[key].toLowerCase())) return false
        }
      }
      return true
    }
  }
}
</script>

<template>
  <div>
    <h1>Eventos</h1>
    <div class="container">
      <input class="item" v-show="visibleItems.includes(sItem)" v-for="sItem of fields" :key='sItem' type="text" @input="search(sItem, $event)" :placeholder="header[sItem]">
    </div>
    <div>
      <div v-for="seeItem of fields" :key="seeItem">
        <input type="checkbox" :id="seeItem" :value="seeItem" v-model="visibleItems">
        <label :for="seeItem">{{header[seeItem]}}</label>
      </div>
    </div>
    <div class="numItems">
      <label>Eventos totales: {{this.myItems.length}}</label>
    </div>
    <table>
      <thead>
        <tr>
          <th v-show="visibleItems.includes(item)" :class="[{active: item === orderObj.item}, {asc: orderObj.isAsc}, {desc: !orderObj.isAsc}]" v-for="item of fields" :key="item" @click="orderItem(item)">
            {{header[item]}}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item of myItems" :key="item.id">
          <td v-show="visibleItems.includes(data)" v-for="data of fields" :key="data + item.id">
            {{item[data]}}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
h1 {
  color: gray;
  text-align: left;
}

.numItems{
  text-align: right;
  margin: 20px 0 20px 0;
}

table {
  border-collapse: collapse;
  width: 100%;
}

.active.desc:after {
  content: "▲";
}

.active.asc:after {
  content: "▼";
}

th, td {
  padding: 1em;
  text-align: left;
  border: 1px solid #ddd;
}

th {
  background-color: #42b983;
  color: white;
  cursor: pointer;
}

tr:hover {
  background-color: lightgray;
}

tr:nth-child(even){background-color: #f2f2f2;}

input[type=text] {
  padding: 12px 20px;
  border-radius: 4px;
  border: 1px solid #ccc;
}

input[type=text]:focus {
  border: 1px solid #42b983;
}

.container {
  display: flex;
  flex-flow: row wrap;
  margin: 10px 0 10px 0;
  justify-content: stretch;
  gap: 10px 20px;
}

.item {
  width: 200px;
  flex-grow: 4;
  flex-shrink: 5;
}

</style>
