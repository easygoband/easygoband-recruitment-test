// Clase API con diferentes métodos para las distintas peticiones del cliente a la API.
export default class API {

    // Petición para obtener la lista de datos.
    obtainData() {
        return fetch('https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1', {
            method: 'GET',
            headers: {
                'Content-type':'application/json',
                'Authorization': 'Basic cJmAc71jah17sgqi1jqaksvaksda='
            }
        }).then(function(response) {
            if (response.ok)
                return response.json()
        })
    }
}