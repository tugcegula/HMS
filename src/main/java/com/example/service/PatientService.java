package com.example.service;

import com.example.entity.Patients;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Optional<Patients> findByPatientId(Long patientId){
        return patientRepository.findById(patientId);
    }
    public List<Patients> getAllPatients(){
        return patientRepository.findAll();
    }

    public List<Patients> getPatientByIdentityNo(long identityNo){
        return patientRepository.findByPatientsIdentityNo(identityNo);
    }
    public void deletePatient(Long patientId){
        if(!patientRepository.existsById(patientId)){
            throw new RuntimeException("Patient not found with this patientId"+ patientId);
        }
        patientRepository.deleteById(patientId);
    }
    public Patients createPatient(Patients patients){
        return patientRepository.save(patients);
    }

}
