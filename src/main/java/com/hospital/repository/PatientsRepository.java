package com.hospital.repository;

import com.hospital.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {
    Patients findByPatientsId(Long patientsId);
    List<Patients> findByPatientsIdentityNo(long patientsIdentityNo);
    List<Patients> findByName(String name);
    List<Patients> findBySurname(String surname);


}
