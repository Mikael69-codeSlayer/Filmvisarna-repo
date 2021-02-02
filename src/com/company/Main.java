package com.company;

import com.company.models.Salons;
import com.company.models.Showtime;
import com.company.models.Ticket;
import com.company.models.User;
import com.company.utilities.HashPassword;
import express.Express;
import express.database.CollectionOptions;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.util.HashMap;
import java.util.Map;

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

        app.put("/rest/showtime/:id", (req, res) -> {

            String id = req.params("id");
            Map body = req.body();
            System.out.println(body);
            Showtime showtime = collection("Showtime").findById(id);
            boolean booked = showtime.updateSeats((int)body.get("bookedSeats"));
            if (booked) {
                collection("Showtime").save(showtime);
                res.send("ok");
            }
            else {
                res.status(400).send("Inte tillräckligt med lediga platser");
            }

        });


        app.get("/rest/login", (req, res) -> {
            res.send("Logga in");
        });


        // listen starts the server
        // and should be done after endpoint-listeners
        app.listen(4000); // note that we can't use the same port as Vue does (3000)

    }
}
