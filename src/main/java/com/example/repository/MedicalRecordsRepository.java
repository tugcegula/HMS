package com.example.repository;

import com.example.entity.MedicalRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords,Long> {
    MedicalRecords findByRecordId(String recordId);
    List<MedicalRecords> findByDoctorUsersIdentityNo(long identityNo);
    List<MedicalRecords> findByPatientsPatientsIdentityNo(long patientsIdentityNo);
}