package com.hospital.controller;

import com.hospital.entity.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Optional<Doctor> getDoctorById(@PathVariable Long doctorId){
        return doctorService.getDoctorById(doctorId);
    }
    //Adding new doctor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 HTTP durum kodu döndürür
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@PathVariable Long doctorId,@RequestBody Doctor doctorDetails ){
        return doctorService.updateDoctor(doctorId, doctorDetails);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId){
        doctorService.deleteDoctor(doctorId);
    }

}
