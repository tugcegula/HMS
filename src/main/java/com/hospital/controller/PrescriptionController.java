package com.hospital.controller;

import com.hospital.entity.Prescription;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    public final PrescriptionService prescriptionService;
    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/{prescriptionId}")
    public Optional<Prescription> getPresceiptionByPrescriptionId(long prescriptionId){
        return prescriptionService.getPrescriptionByPrescriptionId(prescriptionId);
    }
    @GetMapping("/patient/{patientId}")
    public List<Prescription> getPrescriptionByPatientsIdentityNo(long patientsIdentityNo){
        return prescriptionService.getPrescriptionsByPatientsIdentityNo(patientsIdentityNo);
    }
    @GetMapping("/doctor/{doctorId}")
    public List<Prescription> getPrescriptionByDoctorIdentityNo(Long identityNo){
        return prescriptionService.getPrescriptionByDoctorIdentityNo(identityNo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prescription createPrescription(@RequestBody Prescription prescription){
        return prescriptionService.createPrescription(prescription);
    }

}
