package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Salons {
    @Id
    private String id;
    private int salonId;

    private String name;
    private int seats;
    private int[] seatsPerRow;

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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int[] getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int[] seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public int getSalonId() { return salonId;  }

    public void setSalonId(int salonId) { this.salonId = salonId; }



}