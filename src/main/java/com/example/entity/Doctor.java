package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @Column(name="doctorId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName = "id")
    private Users users;
    private int roomNumber;

    public Doctor(Long doctorId, Users users, int roomNumber) {
        this.doctorId = doctorId;
        this.users = users;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


}
