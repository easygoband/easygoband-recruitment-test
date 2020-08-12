import axios from "axios";
require("dotenv").config()

const baseURL="https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers"
const eventId=1
const headers={
  //!!! Set dotenv to: Authorization: process.env.AUTH_TOKEN
  Authorization: "Basic cJmAc71jah17sgqi1jqaksvaksda="
}

class ticketsService {
  constructor() {
    this.ticketsService=axios.create({
      baseURL,
      seUnifiedTopology: true
    });
  }

  getTickets() {
    return this.ticketsService.get(`/${eventId}`, {headers}).then(({data})=>data).catch(err=>{console.log(err)})
  }
}

const axiosRequestFunctions=new ticketsService();

export default axiosRequestFunctions;
