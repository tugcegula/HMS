package com.example.controller;

import com.example.entity.Patients;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/{patientId}")
    public Optional<Patients> findPatientsById(Long patientsId){
        return patientService.findByPatientId(patientsId);
    }
    @GetMapping("/{patientId}")
    public List<Patients> getAllPatients(){
        return patientService.getAllPatients();
    }

    @DeleteMapping("/{patientId}")
    public void deletePaient(Long patient){
        patientService.deletePatient(patient);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patients createPatient(@RequestBody Patients patients){
        return patientService.createPatient(patients);
    }

}
