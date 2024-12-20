package com.hospital.repository;

import com.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByDoctorId(Long doctorId);
    List<Doctor> findByUsersName(String name);
    List<Doctor> findByUsersSurname(String surname);
    Doctor findByUsersIdentityNo(long identityNo);
}
