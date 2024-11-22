package com.hospital.controller;

import com.hospital.entity.Appointments;
import com.hospital.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    @Autowired
    private final AppointmentsService appointmentsService;

    @Autowired
    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }
    @GetMapping("/{appointmentId}")
    public Optional<Appointments> getAppointmentsById(Long appointmentId){
        return appointmentsService.getAppointmentsById(appointmentId);
    }
    @GetMapping("/patient/{patientId}")
    public List<Appointments> getAppointmentByPatientId(Long patientsId){
        return appointmentsService.getAppointmentsByPatientId(patientsId);
    }
    @GetMapping("/doctor/{doctorId}")
    public List<Appointments> getAppointmentByDoctorId(Long doctorId){
        return appointmentsService.getAppointmentsByDoctorId(doctorId);
    }
    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(Long appointmentId){
        appointmentsService.cancelAppointments(appointmentId);
    }
    @PostMapping("/{appointmentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointments createAppointment(@RequestBody Appointments appointments){
        return appointmentsService.createAppointment(appointments);
    }
}
