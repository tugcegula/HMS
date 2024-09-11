package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patients {
    //Hasta (hastaID, adi, soyadi, tc, dogumTarihi, cinsiyet,tel)
    @Id
    @Column(name= "patientsId")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long patientsId;
    private String name;
    private String surname;
    private long tc;
    private int dob;
    private String gender;
    private int phoneNum;

    @OneToMany(mappedBy ="patients")
    @JsonManagedReference
    private List<MedicalRecords> records;

    public Patients(Long patientsId, String name, String surname, long tc, int dob, String gender, int phoneNum) {
        this.patientsId = patientsId;
        this.name = name;
        this.surname = surname;
        this.tc = tc;
        this.dob = dob;
        this.gender = gender;
        this.phoneNum = phoneNum;
    }

    public Long getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(Long patientsId) {
        this.patientsId = patientsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getTc() {
        return tc;
    }

    public void setTc(long tc) {
        this.tc = tc;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
