package com.example.service;

import com.example.entity.Appointments;
import com.example.entity.Doctor;
import com.example.entity.Patients;
import com.example.repository.AppointmentsRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {

    private final AppointmentsRepository appointmentsRepository;
    private DoctorRepository doctorRepository;

    private PatientRepository patientRepository;

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

    public List<Appointments> getAppointmentsByPatientId(Long patientId){
        return appointmentsRepository.findByPatientsPatientsIdentityNo(patientId);
    }

    public List<Appointments> getAppointmentsByDoctorId(Long doctorId){
        return appointmentsRepository.findByDoctorUsersIdentityNo(doctorId);
    }

    public void cancelAppointments(Long appointmentId){
        appointmentsRepository.deleteById(appointmentId);
    }

    public void createAppointment(Appointments appointments, Doctor doctor, Patients patients){
        appointmentsRepository.save(appointments);
        doctorRepository.save(doctor);
        patientRepository.save(patients);
    }

}
