package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

@Model
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private ArrayList <Ticket> bookings;

    public User() {

    }

    public ArrayList<Ticket> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Ticket> bookings) {
        this.bookings = bookings;
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


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
