const axios = require('axios');

const filter = require('../utils/filter');

const controller = {};

controller.prueba = async(req, res, next ) => {
    const name = req.params.nombre;

    axios.get('https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1', {
        headers: {
            'Authorization': 'Basic cJmAc71jah17sgqi1jqaksvaksda='
        }
    })
        .then(response => {
            const filteredList = filter(response.data, name);
            res.send(filteredList);
        })
        .catch(err => {
            console.log(err);
            res.send(err);
        });
    

}

module.exports = controller;