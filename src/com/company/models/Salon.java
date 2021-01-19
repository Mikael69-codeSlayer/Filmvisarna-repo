package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Salon {
    @Id

    public String[] getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(String[] seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }


    private String name;
   private String seats;
   private String[] seatsPerRow;

}
