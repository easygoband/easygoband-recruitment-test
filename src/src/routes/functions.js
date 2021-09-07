const sortArray = require('sort-array')

module.exports = {
    checkFilter: function (data,filters,text) {
        for (let i = 0; i < filters.length; i++) {
            if (filters[i]!=null){
                if(i!=0){
                    if(filters[i].includes('[gte]')){
                        data = data.filter(function(o){
                            return (o[text[i]] >= parseInt(filters[i].substring(filters[i].indexOf(']') + 1)));
                        });
                    }
                    else{
                        if(filters[i].includes('[lte]')){
                            data = data.filter(function(o){
                                return (o[text[i]] <= parseInt(filters[i].substring(filters[i].indexOf(']') + 1)));
                            });
                        }
                        else{
                            data = data.filter(function(o){
                                return (o[text[i]] === parseInt(filters[i]));
                            });
                        }
                    }
                    
                }
                else{
                    data = data.filter(function(o){
                        return (o[text[i]] === filters[i]);
                    });
                }
            }
        }
        return data;
    },

    sort : function(data,sorted_by){
        if(sorted_by.startsWith('desc(')){
            var value = sorted_by.substring(5,sorted_by.lastIndexOf(')'));
            sortArray(data, {by: value,order: 'desc'})
            return data;
        }

        else{
            if(sorted_by.startsWith('asc(')){
                var value = sorted_by.substring(4,sorted_by.lastIndexOf(')'));
                sortArray(data, {by: value,order: 'asc'})
                return data;
            }
            else{
                sortArray(data, {by: sorted_by,order: 'asc'})
                return data;
            }
        }
    },

    group : function(keys){
        return function(data) {
          return data.reduce(function(objects, obj) {
            var value = keys.map(function(key){return (obj[key])}).join('-');
            objects[value] = (objects[value] || []).concat(obj);
            return objects; 
          }, {})
        }
    } 
}
