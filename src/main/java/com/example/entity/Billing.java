package com.example.entity;

import com.example.enums.BillingStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="billing")
public class Billing {
    //billingid, patientid, date,total amount,status,
    @Id
    @Column(name= "billingId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billingId;
    @ManyToOne
    @JoinColumn(name = "patients_id" , referencedColumnName = "patientsId")
    @JsonBackReference
    private Patients patients;
    private LocalDate date;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private BillingStatus status;// array gibi tanımlanacak paid/unpaid/pending vb

    public Billing() {
    }

    public Billing(Long billingId, Patients patients, LocalDate date, double totalAmount, BillingStatus status) {
        this.billingId = billingId;
        this.patients = patients;
        this.date = date;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BillingStatus getStatus() {
        return status;
    }

    public void setStatus(BillingStatus status) {
        this.status = status;
    }
}
