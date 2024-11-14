package com.example.controller;

import com.example.entity.Prescription;
import com.example.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {
    @Autowired
    public final PrescriptionService prescriptionService;
    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/{prescriptionId}")
    public Optional<Prescription> getPresceiptionByPrescriptionId(Long prescriptionId){
        return prescriptionService.getPrescriptionByPrescriptionId(prescriptionId);
    }
    @GetMapping("/patient/{patientId}")
    public List<Prescription> getPrescriptionByPatientsId(Long patientsId){
        return prescriptionService.getPrescriptionsByPatientsId(patientsId);
    }
    @GetMapping("/doctor/{doctorId}")
    public List<Prescription> getPrescriptionByDoctorId(Long doctorId){
        return prescriptionService.getPrescriptionByDoctorId(doctorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prescription createPrescription(@RequestBody Prescription prescription){
        return prescriptionService.createPrescription(prescription);
    }

}
