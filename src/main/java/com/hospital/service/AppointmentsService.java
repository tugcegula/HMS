package com.hospital.service;

import com.hospital.entity.Appointments;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patients;
import com.hospital.repository.AppointmentsRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;
    private DoctorRepository doctorRepository;
    private PatientsRepository patientRepository;

    @Autowired
    public AppointmentsService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }
//    public Appointments scheduleAppointmens(Appointments appointments){
//        return appointmentsRepository.save(appointments);
//    }
    public Optional<Appointments> getAppointmentsById(Long appointmentId) {
        return Optional.ofNullable(appointmentsRepository.findByAppointmentId(appointmentId));
    }

    public List<Appointments> getAppointmentsByPatientId(Long patientsId){
        return appointmentsRepository.findByPatientsPatientsIdentityNo(patientsId);
    }

    public List<Appointments> getAppointmentsByDoctorId(Long doctorId){
        return appointmentsRepository.findByDoctorUsersIdentityNo(doctorId);
    }

    public void cancelAppointments(Long appointmentId){
        appointmentsRepository.deleteById(appointmentId);
    }

    public Appointments createAppointment(Appointments appointments){
        Doctor doctor= doctorRepository.findById(appointments.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patients patients =patientRepository.findById(appointments.getPatients().getPatientsId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointmentsRepository.save(appointments);
        appointments.setDoctor(doctor);
        appointments.setPatients(patients);
        return appointmentsRepository.save(appointments);
    }


}
