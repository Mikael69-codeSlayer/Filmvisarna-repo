package com.company;

import com.company.models.User;
import com.company.utilities.HashPassword;
import express.Express;
import org.dizitart.no2.objects.filters.ObjectFilters;

import static express.database.Database.collection;

public class Auth {
    private Express app;

    public Auth(Express app) {
        this.app = app;
        initAuth();
    }
    private void initAuth(){
        String secretSalt = "hnjfew45%!dhDsdqw-_!dwOL";

        //post send information to database
        app.post("/api/register", (req, res) -> {
            if(req.session("user") != null) {
                res.send("Redan inloggad");
                return;
            }

            var user = req.body(User.class);
            System.out.println(user);

            // validate email to avoid copies
            User existingUser = collection("User").findOne(ObjectFilters.eq("email", user.getEmail()));
            if(existingUser != null) {
                // email taken
                res.send("E-postadressen används redan");
                return; // don't save the user
            }

            String hashedPassword = HashPassword.hash(user.getPassword() + secretSalt);
            user.setPassword(hashedPassword);

            collection("User").save(user);

            user.setPassword(null);
            //save user in session
            req.session("user", user);

            res.json(user);
        });

        app.post("/api/login", (req, res) -> {
            if (req.session("user") != null) {
                res.send("Redan inloggad");
                return;
            }

            var user = req.body(User.class);

            User existingUser = collection("User").findOne(ObjectFilters.eq("email", user.getEmail()));

            if (existingUser == null) {
                res.send("Fel e-postadress eller lösenord");
                return;
            }

            if (HashPassword.match(user.getPassword() + secretSalt, existingUser.getPassword())) {

               existingUser.setPassword(null);

                req.session("user", existingUser);
                //correct email + password
                res.json(existingUser);

            } else {
                res.send("Fel e-postadress eller lösenord");
            }
        });
        //get gets the information that already exists. Returns user that is logged in / registered
        app.get("/api/whoami", (req, res) -> {

            User user = req.session("user");
            res.json(user);
        });

        app.get("api/logout", (req, res) -> {
            req.session("user", null);
            res.send("Utloggad");
        });

    }
}
