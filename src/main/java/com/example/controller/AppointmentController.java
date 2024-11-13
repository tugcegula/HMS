package com.example.controller;

import com.example.entity.Appointments;
import com.example.entity.Doctor;
import com.example.service.AppointmentsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private AppointmentsService appointmentsService;

    public AppointmentController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }
    @GetMapping("/{appointmentId}")
    public Optional<Appointments> getAppointmentsById(Long appointmentId){
        return appointmentsService.getAppointmentsById(appointmentId);
    }
    @GetMapping
    public List<Appointments> getAppointmentByPatientId(Long patientId){
        return appointmentsService.getAppointmentsByPatientId(patientId);
    }
    @GetMapping
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
