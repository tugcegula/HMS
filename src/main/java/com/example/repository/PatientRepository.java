package com.example.repository;

import com.example.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patients, Long> {
    Optional<Patients> findById(Long id);

}
