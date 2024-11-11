package com.example.service;

import com.example.entity.MedicalRecords;
import com.example.repository.MedicalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordsService {

    private MedicalRecordsRepository medicalRecordsRepository;

    @Autowired
    public MedicalRecordsService(MedicalRecordsRepository medicalRecordsRepository){
        this.medicalRecordsRepository= medicalRecordsRepository;
    }

    public List<MedicalRecords> getMedicalRecordsByPatient(Long patientId){
        return medicalRecordsRepository.findByPatientsPatientsIdentityNo(patientId);
    }

    public List<MedicalRecords> getMedicalRecordsByDoctor(Long doctorId){
        return medicalRecordsRepository.findByDoctorUsersIdentityNo(doctorId);
    }

    public MedicalRecords createMedicalRecords(MedicalRecords medicalRecords){
        return medicalRecordsRepository.save(medicalRecords);
    }
}
