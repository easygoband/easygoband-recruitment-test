const fs = require('fs');
const axios = require('axios');
const express = require('express');
const { response, Router } = require('express');


const filterdata = require('./filter.js')

async function callAPI(ID){

  const url = 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1';
  const credential = 'Basic cJmAc71jah17sgqi1jqaksvaksda=';
  const method = 'GET';

  return await axios.get(url, {
    headers: {
      'Authorization': credential
    }
  })

}


module.exports = callAPI

    

    
