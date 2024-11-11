package com.example.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="appointments")
public class Appointments {
    //Randevu (randevuID, tarih, sıra,saat
    @Id
    @Column(name= "appointmentId")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long appointmentId;
    private LocalDate date;
    private int number;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "patients_id" , referencedColumnName = "patientsId")
    @JsonBackReference
    private Patients patients;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , referencedColumnName = "doctorId")
    @JsonBackReference
    private Doctor doctor;


    public Appointments(Long appointmentId, LocalDate date, int number, LocalDateTime time, Patients patients, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.number = number;
        this.time = time;
        this.patients = patients;
        this.doctor= doctor;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
