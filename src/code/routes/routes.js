const express = require('express');
const controller = require('../controller/controller');

const router = express.Router();

router.get('/prueba/:nombre', controller.prueba);

module.exports = router;