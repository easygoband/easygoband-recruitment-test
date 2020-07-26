import axios from "axios";

export default axios.create({
  baseURL: `https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/`,
  headers: {
    Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda=",
  },
});
