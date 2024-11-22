package com.hospital.repository;

import com.hospital.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription findByPrescriptionId(Long prescriptionId);
    List<Prescription> findByDoctorUsersIdentityNo(long identityNo);
    List<Prescription> findByPatientsPatientsIdentityNo(long patientsIdentityNo);

}
