package com.example.repository;

import com.example.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {
    Patients findByPatientsIdentityNo(long patientsIdentityNo);
    List<Patients> findByName(String name);
    List<Patients> findBySurname(String surname);

}
