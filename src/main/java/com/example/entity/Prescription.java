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
    @ManyToOne
    @JoinColumn(name = "recordId", referencedColumnName = "recordId")
    private MedicalRecords medicalRecord;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Prescription() {
    }

    public Prescription(Long prescriptionId, Doctor doctor, Patients patients, MedicalRecords medicalRecord, Date date) {
        this.prescriptionId = prescriptionId;
        this.doctor = doctor;
        this.patients = patients;
        this.medicalRecord = medicalRecord;
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

    public MedicalRecords getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecords medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

