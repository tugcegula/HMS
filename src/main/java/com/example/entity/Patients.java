package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

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
    private long patientsIdentityNo;
    private int dob;
    private String gender;
    private int phoneNum;

    @OneToMany(mappedBy ="patients",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MedicalRecords> records;

    @OneToMany(mappedBy ="patients",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Billing> billings;

    public Patients() {
    }

    public Patients(Long patientsId, String name, String surname, long patientsIdentityNo, int dob, String gender, int phoneNum) {
        this.patientsId = patientsId;
        this.name = name;
        this.surname = surname;
        this.patientsIdentityNo = patientsIdentityNo;
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

    public long getPatientsIdentityNo() {
        return patientsIdentityNo;
    }

    public void setPatientsIdentityNo(long patientsIdentityNo) {
        this.patientsIdentityNo = patientsIdentityNo;
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
