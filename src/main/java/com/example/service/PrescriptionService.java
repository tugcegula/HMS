package com.example.service;

import com.example.entity.Patients;
import com.example.entity.Prescription;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository=prescriptionRepository;
    }

    public List<Prescription> getPrescriptionsByPatient(Long patientId){
        return prescriptionRepository.findByPatientsPatientsIdentityNo(patientId);
    }

    public List<Prescription> getPrescriptionByDoctor(Long doctorId){
        return prescriptionRepository.findByDoctorUsersIdentityNo(doctorId);
    }

    public Prescription createPrescription(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

}
