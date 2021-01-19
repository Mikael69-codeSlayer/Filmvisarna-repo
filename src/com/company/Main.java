package com.company;
//import com.company.models.Todo;
import express.Express;
import express.database.CollectionOptions;

import static express.database.Database.collection;

public class Main {

    public static void main(String[] args) {

        // instantiate the app
        Express app = new Express();
        app.enableCollections();
        // "/" defaults to homepage
        // req = Request;  res = Response
        // req - server gets a question

        // path is the endpoint url the method listens to
        // res - answer to the question, for instance number, String or object information

        app.get("/rest/filmer", (req, res) -> {
            res.send("Filmer & Trailer");
            var filmer = collection("Filmer").find();
            res.json(filmer);
        });
        /*
        app.get("/rest/salon", (req, res) -> {
            var salon = collection("Salon").find();
            res.json(salon);
        });
        app.get("/rest/ticket", (req, res) -> {
            var ticket = collection("Ticket").find();
            res.json(ticket);
        });*/

        app.get("/rest/login", (req, res) -> {
            res.send("Logga in");
        });


        // listen starts the server
        // and should be done after endpoint-listeners
        app.listen(4000); // note that we can't use the same port as Vue does (3000)

    }
}
