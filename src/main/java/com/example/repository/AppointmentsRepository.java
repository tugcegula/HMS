package com.example.repository;

import com.example.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
    Appointments findByAppointmentId(Long appointmentId);
    List<Appointments> findByPatientsPatientsIdentityNo(long patientsIdentityNo);

    List<Appointments> findByDoctorUsersIdentityNo(long identityNo);
}
