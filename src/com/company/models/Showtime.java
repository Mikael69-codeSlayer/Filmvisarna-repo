package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Showtime {

    @Id
    private String id;

    private String salon;
    private String film;
    private String date;
    private String time;
    private String showId;
    private int availableSeats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean updateSeats(int bookedSeats) {

        if (this.availableSeats >= bookedSeats) {
            this.availableSeats -= bookedSeats;
            return true;
        }
        else { return false; }
    }
}
