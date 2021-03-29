function filter(elementsList, name) {
    
    let filteredList = [];

    for(let x = 0; x < elementsList.length; x++){

        if(elementsList[x].sessions[0].name == name){
            filteredList.push(elementsList[x]);
        }
        
    }

    return filteredList;
}

module.exports = filter;