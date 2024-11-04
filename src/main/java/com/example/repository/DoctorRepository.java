package com.example.repository;

import com.example.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByDoctorId(Long doctorId);
    List<Doctor> findByName(String name);
    List<Doctor> findBySurname(String surname);
    Doctor findByIdentityNo(long identityNo);
}
