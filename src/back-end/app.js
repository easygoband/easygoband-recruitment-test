const express = require('express');
const axios = require('axios')

const allElemntRoutes = require('./routes/allElements.js')
const idElemntRoutes = require('./routes/idElements.js')

const app = express();
const port = 3000;


app.use(allElemntRoutes);
app.use(idElemntRoutes);


app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
