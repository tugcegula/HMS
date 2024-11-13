package com.example.controller;

import com.example.entity.MedicalRecords;
import com.example.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicalRecords")
public class MedicalRecordsController {

    private MedicalRecordsService medicalRecordsService;

    @Autowired
    public MedicalRecordsController(MedicalRecordsService medicalRecordsService) {
        this.medicalRecordsService = medicalRecordsService;
    }
    @GetMapping
    public List<MedicalRecords> getAllMedicalRecords(){
        return medicalRecordsService.getAllMedicalRecords();
    }

    @GetMapping("/{recordId}")
    public Optional<MedicalRecords> getMedicalRecords(Long recordId){
        return medicalRecordsService.getMedicalRecordsByMedicalRecordsId(recordId);
    }
    @GetMapping
    public List<MedicalRecords> getMedicalRecordByPatientId(Long patientId){
        return medicalRecordsService.getMedicalRecordsByPatient(patientId);
    }
    @GetMapping
    public List<MedicalRecords> getMedicalRecordbyDoctorId(Long doctorId){
        return medicalRecordsService.getMedicalRecordsByDoctor(doctorId);
    }

    @PostMapping("/{recordId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalRecords createMedicalRecords(@RequestBody MedicalRecords medicalRecords){
        return medicalRecordsService.createMedicalRecords(medicalRecords);
    }

}
