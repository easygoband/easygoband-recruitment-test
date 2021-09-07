var axios = require('axios');

module.exports = {
    getData: function () {
        var config = {
            method: 'get',
                url: 'https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1',
            headers: { 
                'Authorization': 'Basic cJmAc71jah17sgqi1jqaksvaksda='
            }
        };
    
        const promise = axios(config)
        .then( ((response) => response.data))
        .catch(function (error) {
            console.log(error);
        });
        
        return promise;
        
    }
}
