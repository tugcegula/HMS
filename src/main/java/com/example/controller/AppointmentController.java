package com.example.controller;

import com.example.entity.Patients;
import com.example.service.AppointmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private AppointmentsService appointmentsService;

    public AppointmentController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

//    @GetMapping
//    public List<Patients> get
}
