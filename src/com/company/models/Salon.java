package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Salon {
    @Id
    private String salonName;
    private int seats;
    private int[] seatsPerRow;

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
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

}
