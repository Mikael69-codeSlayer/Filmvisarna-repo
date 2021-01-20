package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Salon {
    @Id
    private String id;

    private String name;
    private String seats;
    private String[] seatsPerRow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String[] getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(String[] seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }



}