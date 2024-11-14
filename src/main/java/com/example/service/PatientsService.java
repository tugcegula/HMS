package com.example.service;

import com.example.entity.Patients;
import com.example.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    private final PatientsRepository patientRepository;
    @Autowired
    public PatientsService(PatientsRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Optional<Patients> findByPatientId(Long patientsId){
        return patientRepository.findById(patientsId);
    }
    public List<Patients> getAllPatients(){
        return patientRepository.findAll();
    }

    public List<Patients> getPatientByIdentityNo(long identityNo){
        return patientRepository.findByPatientsIdentityNo(identityNo);
    }
    public void deletePatient(Long patientsId){
        if(!patientRepository.existsById(patientsId)){
            throw new RuntimeException("Patient not found with this patientId"+ patientsId);
        }
        patientRepository.deleteById(patientsId);
    }
    public Patients createPatient(Patients patients){
        return patientRepository.save(patients);
    }

}
