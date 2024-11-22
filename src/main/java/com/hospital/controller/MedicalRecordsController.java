package com.hospital.controller;

import com.hospital.entity.MedicalRecords;
import com.hospital.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalRecords")
public class MedicalRecordsController {
    @Autowired
    private final MedicalRecordsService medicalRecordsService;

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
    @GetMapping("/patient/{patientsIdentityNo}")
    public List<MedicalRecords> getMedicalRecordByPatientIdentityNo(long patientsIdentityNo){
        return medicalRecordsService.getMedicalRecordsByPatientIdentityNo(patientsIdentityNo);
    }
    @GetMapping("/doctor/{identityNo}")
    public List<MedicalRecords> getMedicalRecordbyDoctorIdIdentityNo(long identityNo){
        return medicalRecordsService.getMedicalRecordsByDoctorIdentityNo(identityNo);
    }

    @PostMapping("/{recordId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalRecords createMedicalRecords(@RequestBody MedicalRecords medicalRecords){
        return medicalRecordsService.createMedicalRecords(medicalRecords);
    }

}
