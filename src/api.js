const url =
  "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1";
const auth = "Basic cJmAc71jah17sgqi1jqaksvaksda=";

function getAssets() {
  return fetch(url, {
    method: "GET",
    headers: {
      "Content-type": "application/json",
      Authorization: auth,
    },
  }).then((res) => res.json());
}

export default {
  getAssets,
};
