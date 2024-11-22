package com.hospital.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @Column(name="doctorId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Users users;
    @OneToMany(mappedBy = "doctor")
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<MedicalRecords> medicalRecords;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescription;
    private int roomNumber;

    public Doctor() {
    }

    public Doctor(Long doctorId, Users users, List<Appointments> appointments, List<MedicalRecords> medicalRecords, List<Prescription> prescription, int roomNumber) {
        this.doctorId = doctorId;
        this.users = users;
        this.appointments = appointments;
        this.medicalRecords = medicalRecords;
        this.prescription = prescription;
        this.roomNumber = roomNumber;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public List<MedicalRecords> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
