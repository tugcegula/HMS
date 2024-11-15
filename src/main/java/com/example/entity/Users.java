package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
    //(personelID, adi, soyadi, tc, brans,duyuruID,odaID,yetkiID
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private long identityNo;
    private String title;

    @OneToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    private Doctor doctor;

    public Users() {
    }

    public Users(Long id, String name, String surname, long identityNo, String branch) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identityNo = identityNo;
        this.title = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(long identityNo) {
        this.identityNo = identityNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
