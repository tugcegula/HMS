package com.example.repository;

import com.example.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription findByRecordId(String recordId);
    List<Prescription>findByIdentityNo(Long identityNo);
    List<Prescription> findByPatientsIdentityNo(Long patientsIdentityNo);
}
