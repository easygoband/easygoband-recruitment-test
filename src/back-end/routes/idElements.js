const express = require('express')
const filterdata = require('../filter.js')
const callAPI = require('../req.js');

let routerID =  express.Router();


// Retorna objeto filtrado por ID

routerID.get('/:id', (req, res) => {

    const url = 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1';
    const credential = 'Basic cJmAc71jah17sgqi1jqaksvaksda=';
  
    let ID = req.params.id
  
  
  
    callAPI(req.params.id).then(function (response) {
            // handle success
            res.send(filterdata(response.data, ID));
          })
  
  })


module.exports = routerID;