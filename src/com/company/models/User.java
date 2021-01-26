package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class User {

    @Id
    private String id;
    private String email;
    private String password;

   // List <Booking> bookings;  Lägg till för att kunna se bokningar.


    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   // @JsonIgnore -- tar bort password när man hämtar en user
    public String getPassword() {
        return password;
    }

    //@JsonProperty  -- tillåter password att tas emot av express
    public void setPassword(String password) {
        this.password = password;
    }

   // @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
