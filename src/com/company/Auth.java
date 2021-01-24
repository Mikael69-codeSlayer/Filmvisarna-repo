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
        String secretSalt = "hnjfew45%!dhDsdqw-_!dwOL";  //googla på load from environment

        app.post("/api/register", (req, res) -> {
            if(req.session("current-user") != null) {
                res.send("Redan inloggad");
                return;
            }

            var user = req.body(User.class);
            System.out.println(user);

            // validera att email inte är upptaget
            User existingUser = collection("User").findOne(ObjectFilters.eq("email", user.getEmail()));
            if(existingUser != null) {
                // email upptagen
                res.send("E-postadressen används redan");
                return; // spara inte användaren
            }

            String hashedPassword = HashPassword.hash(user.getPassword() + secretSalt);
            user.setPassword(hashedPassword);

            collection("User").save(user);

            user.setPassword(null);

            // spara användaren i sessionen
            req.session("current-user", user);

            res.json(user);
        });

        app.post("/api/login", (req, res) -> {
            if (req.session("current-user") != null) {
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
                req.session("current-user", existingUser);

                res.json(existingUser); //rätt email + lösenord

            } else {
                res.send("Fel e-postadress eller lösenord");
            }
        });

        app.get("/api/whoami", (req, res) -> {

            User user = req.session("current-user");
            res.json(user);
        });
        app.get("api/logout", (req, res) -> {
            req.session("current-user", null);
            res.send("Utloggad");
        });

    }
}
