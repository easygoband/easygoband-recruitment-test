const cors = require("cors");
const express = require("express");
const fetch = require("node-fetch");

/* Herpku already sets a port */
const port = process.env.PORT || 8888;

var app = express();

/* USE CORS */
app.use(cors({ origin: "*" }));

/* LISTEN TO PORT */
app.listen(port, () => console.log(`Listening on port ${port}`));

/* API URL */
const url =
    "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1";
const authorization = "Authorization";
const apikey = "Basic cJmAc71jah17sgqi1jqaksvaksda=";

/* MAIN */
app.get("/", function (req, res) {
    const sessionName = req.query.sessionName;

    fetch(url, {
        headers: {
            "Content-Type": "application/json",
            authorization: apikey,
        },
    })
        .then((res) => res.json())
        .then((json) => {
            res.send(filterJSON(json, sessionName));
        })
        .catch((error) => {
            console.log(error);
            res.send("Something went wrong");
        });
});

function filterJSON(json, key) {
    var data = [];

    for (var i = 0; i < json.length; i++) {
        if (json[i].sessions[0].name == key) {
            data.push(json[i]);
        }
    }

    return data;
}