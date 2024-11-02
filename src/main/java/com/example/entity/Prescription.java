package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientsId", referencedColumnName = "patientsId")
    private Patients patients;

    @Temporal(TemporalType.DATE)
    private Date date;


    public Prescription(Long prescriptionId, Doctor doctor, Patients patients, Date date) {
        this.prescriptionId = prescriptionId;
        this.doctor = doctor;
        this.patients = patients;
        this.date = date;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

