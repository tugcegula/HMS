package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id){
        return Optional.ofNullable(doctorRepository.findByDoctorId(id));
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor doctor){
        if(!doctorRepository.existsById(id)){
            throw new RuntimeException("Doctor not found with this id: " + id);
        }
        doctor.setDoctorId(id);
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId){
        if(!doctorRepository.existsById(doctorId)){
            throw new RuntimeException("Doctor not found with this doctorId: " + doctorId);
        }
        doctorRepository.deleteById(doctorId);
    }
}
