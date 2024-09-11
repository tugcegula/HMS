package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="appointments")
public class Appointments {
    //Randevu (randevuID, tarih, sıra,saat
    @Id
    @Column(name= "randevuId")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long randevuId;
    private int date;
    private int number;
    private int time;

    public Appointments(Long randevuId, int date, int number, int time) {
        this.randevuId = randevuId;
        this.date = date;
        this.number = number;
        this.time = time;
    }

    public Long getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(Long randevuId) {
        this.randevuId = randevuId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
