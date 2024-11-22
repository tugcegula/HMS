package com.hospital.service;

import com.hospital.entity.Prescription;
import com.hospital.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository=prescriptionRepository;
    }
    public Optional<Prescription> getPrescriptionByPrescriptionId(Long prescriptionId){
        return Optional.ofNullable(prescriptionRepository.findByPrescriptionId(prescriptionId));
    }
    public List<Prescription> getPrescriptionsByPatientsIdentityNo(long patientsIdentityNo){
        return prescriptionRepository.findByPatientsPatientsIdentityNo(patientsIdentityNo);
    }

    public List<Prescription> getPrescriptionByDoctorIdentityNo(long identityNo){
        return prescriptionRepository.findByDoctorUsersIdentityNo(identityNo);
    }

    public Prescription createPrescription(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

}
