const express = require('express');
const app = express();


app.set('port',process.env.PORT || 3000);
app.set('json spaces', 2);
app.use(express.json());


app.use(require('./routes/index'));


app.listen(app.get('port'), () =>{

})