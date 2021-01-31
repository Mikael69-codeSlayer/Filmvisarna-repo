package com.company.models;

import express.database.Model;
import org.dizitart.no2.objects.Id;

@Model
public class Ticket {
    @Id
    private String id;
    private String userId;
    private String auditorium;
    private String film;
    private String date;
    private String time;             //private int price?? kanske hur många säten också?
    private int seats;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", auditorium='" + auditorium + '\'' +
                ", film='" + film + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seats=" + seats +
                ", price=" + price +
                '}';
    }
}
