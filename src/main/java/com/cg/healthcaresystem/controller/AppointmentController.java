package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment)
    {
        appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<Set<Appointment>>viewAllAppointment(@RequestBody String patientName)
    {
        Set<Appointment> appointments=appointmentService.viewAppointments(patientName);
        return new ResponseEntity<>(appointments,HttpStatus.ACCEPTED);
    }
}