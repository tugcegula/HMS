package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="medicalrecords")
public class MedicalRecords {
    //HastaBilgisi(bilgiID, personelD, hastaID, recetelD)
    @Id
    @Column(name= "recordId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "patients_id" , referencedColumnName = "patientsId")
    @JsonBackReference
    private Patients patients;

//Doktor eklenince

    @ManyToOne
    @JoinColumn(name = "doctor_id" , referencedColumnName = "doctorId")
    @JsonBackReference
    private Doctor doctor;


    //Reçete eklenince eklenince
    @OneToMany(mappedBy ="medicalRecord",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Prescription> prescriptions;
//@ManyToOne
////@JoinColumn(name = "" , referencedColumnName = "")
////@JsonBackReference
////private ;

    public MedicalRecords(Long recordId, Patients patients, Doctor doctor, List<Prescription> prescriptions) {
        this.recordId = recordId;
        this.patients = patients;
        this.doctor = doctor;
        this.prescriptions = prescriptions;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
