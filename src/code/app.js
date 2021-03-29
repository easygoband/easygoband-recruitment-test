const express = require('express');

const app = express();

const routes = require('./routes/routes');

app.use(routes);

app.use('/', (req, res, next) => {
    res.send( '<h1>Prueba para Easygoband</h1>' );
});

app.listen(3000);