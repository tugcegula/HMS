package com.example.controller;

import com.example.entity.Patients;
import com.example.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientsController {
    @Autowired
    private final PatientsService patientsService;
    @Autowired
    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }
    @GetMapping("/{patientsId}")
    public Optional<Patients> findPatientsById(@PathVariable Long patientsId){
        return patientsService.findByPatientId(patientsId);
    }
    @GetMapping("/all")
    public List<Patients> getAllPatients(){
        return patientsService.getAllPatients();
    }

    @DeleteMapping
    public void deletePaient(Long patientsId){
        patientsService.deletePatient(patientsId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patients createPatient(@RequestBody Patients patients){
        return patientsService.createPatient(patients);
    }

}
