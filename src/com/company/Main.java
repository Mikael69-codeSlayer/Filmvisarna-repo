package com.company;

import com.company.models.Ticket;
import com.company.models.User;
import com.company.utilities.HashPassword;
import express.Express;
import express.database.CollectionOptions;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.util.HashMap;

import static express.database.Database.collection;

public class Main {

    public static void main(String[] args) {


        // instantiate the app
        Express app = new Express();
        app.enableCollections();
        // "/" defaults to homepage
        // req = Request;  res = Response
        // req - server gets a question
        new Auth(app);

        // path is the endpoint url the method listens to
        // res - answer to the question, for instance number, String or object information

        app.get("/rest/filmer", (req, res) -> {
            res.send("Filmer & Trailer");
            var filmer = collection("Filmer").find();
            res.json(filmer);
        });

        app.get("/rest/salons", (req, res) -> {
            var salons = collection("Salons").find();
            res.json(salons);
        });

        app.get("/rest/ticket", (req, res) -> {
            var ticket = collection("Ticket").find();
            res.json(ticket);
        });

        app.post("/rest/ticket", (req, res) -> {
            User user = req.session("current-user");
            if(user == null ){
                res.send("Du måste vara inloggad för att kunna boka en biljett");
                return;
            }
            Ticket ticket = req.body(Ticket.class);
            ticket.setUserId(user.getId());

            collection("Ticket").save(ticket);                 //Lägger till en ny ticket till database
            res.json(ticket);

        });


        app.get("/rest/showtime", (req, res) -> {
            res.send("Showtime");
            var showtime = collection("Showtime").find();
            res.json(showtime);

        });


        app.get("/rest/login", (req, res) -> {
            res.send("Logga in");
        });


        // listen starts the server
        // and should be done after endpoint-listeners
        app.listen(4000); // note that we can't use the same port as Vue does (3000)

    }
}
