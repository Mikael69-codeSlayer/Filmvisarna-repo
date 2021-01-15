package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Showtime {
    @Id
    private String auditorium;
    private String film;
    private String date;
    private String time;

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
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

}
