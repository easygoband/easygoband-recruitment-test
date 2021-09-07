const  {Router} = require('express');
const router = Router();
const conexion = require("../conexion");
const functions = require("./functions");


router.get('/', (req,res) => {
    conexion.getData()
    .then(data => {
        res.json(data)
    })
    .catch(err => console.log(err))
});

router.get('/items', (req,res) => {
    const offset = req.query.offset;
    const limit = req.query.limit;
    const sorted_by = req.query.sorted_by;
    const id = req.query.id;
    const access_group_name = req.query.access_group_name;
    const access_group_id = req.query.access_group_id;
    const basic_product_id = req.query.basic_product_id;
    const event_id = req.query.event_id;
    const group_by =req.query.group_by;
    const filters = [access_group_name,id,access_group_id,basic_product_id,event_id];
    const text = ["access_group_name","id","access_group_id","basic_product_id","event_id"];
    conexion.getData()
    .then(data => { 
        if(group_by!=null){
            var arrayDeCadenas = group_by.split(' ');
            const groupFilter = functions.group(arrayDeCadenas);
            res.json(groupFilter(data));
        }
        else{
            data = functions.checkFilter(data, filters,text);
            if(sorted_by!=null){
                functions.sort(data,sorted_by);
            }
            if(offset<=0){res.json(data.slice(0,limit));}
            else{res.json(data.slice(offset-1,limit));}
            
        }   
    })
    .catch(err => console.log(err))
});



module.exports = router;