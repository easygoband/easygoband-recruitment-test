async function getData(url, key) {
    let data = await fetch(url, {
        method: "GET",
        headers: {
            Accept: "application/json",
            "Content-type": "application/json",
            Authorization: key
        }
    });
    return data;
}
export default getData;
