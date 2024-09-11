package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="medicalrecords")
public class MedicalRecords {
    //HastaBilgisi(bilgiID, personelD, hastaID, recetelD)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    @ManyToOne
    @JoinColumn(name = "patients_id" , referencedColumnName = "patientsId")
    @JsonBackReference
    private Patients patients;

//Doktor eklenince
//    @OneToMany(mappedBy ="")
//    @JsonManagedReference
//    private List<MedicalRecords> records;
//@ManyToOne
//@JoinColumn(name = "" , referencedColumnName = "")
//@JsonBackReference
//private ;


    //Reçete eklenince eklenince
//    @OneToMany(mappedBy ="")
//    @JsonManagedReference
//    private List<MedicalRecords> records;
//@ManyToOne
//@JoinColumn(name = "" , referencedColumnName = "")
//@JsonBackReference
//private ;


}
