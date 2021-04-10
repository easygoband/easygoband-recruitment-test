const axios = require('axios');
const express = require('express');


callFiltrado: function callFiltrado(response , ID) {
      let found = false;

      for (i=0 ; i< response.length ; i++)
      {
          if ((response[i].id).toString() === ID)
          {   
            found = true;
            return response[i];
          }
      }

      if(found === false){
        return 'User ID not found';
      }

}


module.exports = callFiltrado




