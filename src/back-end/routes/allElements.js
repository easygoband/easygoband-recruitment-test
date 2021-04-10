const express = require('express')
const filterdata = require('../filter.js')
const callAPI = require('../req.js');


let routerAll =  express.Router();


// Retorna la lista completa de objetos

routerAll.get('/all', (req,res)=> {

    const url = 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1';
    const credential = 'Basic cJmAc71jah17sgqi1jqaksvaksda=';
    
    callAPI(req.params.id).then(function (response) {
      // handle success
      res.send(response.data);
    })
  
  })


module.exports = routerAll;