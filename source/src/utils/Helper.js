function mapData(source, callback) {
    let newData = [];
    for(const item in source) {
        let person = callback(source[item]);
        newData.push(Object.assign({}, person));
    }
    return Object.assign({}, [...newData]);
}

function mapFilters(options, callback) {
      let newData = {};
      for(const key in callback(options[0])) {
            newData[key] = [];
            for(let i = 0; i < options.length; i++) {
                  let option = callback(options[i])[key];
                  if(!newData[key].includes(option)) {
                        newData[key].push(option);
                  }
                  continue;
            }
            if(newData[key].every(item => typeof item === 'number')) {
                  newData[key].sort((a,b) => a - b);
            }
            newData[key].sort()
      }
    return newData;
}

function filtersFill(filters) {
    let status = 0;
    Object.values(filters).forEach(filter => {
        status += Boolean(filter);
    });
    return status;
}

export { mapData, mapFilters, filtersFill };
