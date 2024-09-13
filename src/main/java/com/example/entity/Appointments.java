package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
public class Appointments {
    //Randevu (randevuID, tarih, sıra,saat
    @Id
    @Column(name= "randevuId")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long randevuId;
    private LocalDate date;
    private int number;
    private LocalDateTime time;

    public Appointments(Long randevuId, LocalDate date, int number, LocalDateTime time) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
