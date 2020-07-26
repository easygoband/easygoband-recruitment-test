<template>
  <v-container>
    <v-row align="center" justify="center">
      <v-col class="text-center">
        <v-card v-if="!this.errors.length > 0">
          <v-card-title>
            Providers
            <v-spacer></v-spacer>
            <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Session name"
              single-line
              hide-details
            ></v-text-field>
          </v-card-title>
          <v-spacer></v-spacer>
          <v-data-table
            :headers="headers"
            :items="items"
            :search="search"
            :loading="isLoading"
            :loading-text="loadingText"
          >
            <template v-slot:item.modified="{ item }">
              {{ parseToDate(item.modified) }}
            </template>
          </v-data-table>
        </v-card>
        <v-alert
          v-if="this.errors.length > 0"
          border="bottom"
          colored-border
          type="warning"
          elevation="2"
        >
          {{ errors[0].message }}
        </v-alert>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import HTTP from "../utils/http-common";
import { parse, format } from "date-fns";
const headers = [
  {
    text: "Event ID",
    value: "event_id",
    filterable: false,
  },
  {
    text: "Access group ID",
    value: "access_group_id",
    filterable: false,
  },
  {
    text: "Access group name",
    value: "access_group_name",
    filterable: false,
  },
  {
    text: "Basic product id",
    value: "basic_product_id",
    filterable: false,
  },
  {
    text: "Modified",
    value: "modified",
    filterable: false,
  },
  {
    text: "Name",
    value: "name",
    filterable: false,
  },
  {
    text: "Session name",
    value: "sessions[0].name",
  },
  {
    text: "Session ID",
    value: "sessions[0].id",
    filterable: false,
  },
  {
    text: "Total uses",
    value: "total_uses",
    filterable: false,
  },
  {
    text: "Structure decode",
    value: "structure_decode",
    filterable: false,
  },
];
export default {
  name: "Providers",
  data() {
    return {
      isLoading: true,
      loadingText: "Loading... Please wait",
      search: "",
      headers: headers,
      items: [],
      errors: [],
      eventId: 1,
    };
  },
  mounted() {
    HTTP.get(`providers/${this.eventId}`)
      .then((response) => {
        this.items = response.data;
      })
      .catch((error) => {
        this.errors.push(error.response.data);
      })
      .finally(() => (this.isLoading = false));
  },
  methods: {
    parseToDate(date) {
      const newDate = parse(date, "yyyy-MM-dd'T'HH:mm:ss.SSSX", new Date());
      return format(newDate, "PPp");
    },
  },
};
</script>
