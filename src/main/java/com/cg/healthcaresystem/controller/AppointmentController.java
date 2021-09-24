package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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

    @DeleteMapping("/delete by id")
    public ResponseEntity<Appointment> removeAppointment(@RequestBody Appointment appointment)
    {
        Appointment appointments=appointmentService.removeAppointment(appointment);
        return new ResponseEntity<>(appointments,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/view by id")
    public ResponseEntity<Optional<Appointment>> viewAppointment(@RequestBody int appointmentId)
    {

        Optional<Appointment> appointments =appointmentService.viewAppointment(appointmentId);
        return new ResponseEntity<>(appointments,HttpStatus.UPGRADE_REQUIRED);
    }
    @PutMapping ("/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment)
    {
        Appointment appointments =appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(appointments,HttpStatus.UPGRADE_REQUIRED);
    }
    @GetMapping("view list of appointment  ")
    public ResponseEntity<List<Appointment>> getAppointmentList(@RequestBody int centreId, @RequestBody String test, @RequestBody int Status)
    {
        return ResponseEntity.ok(this.appointmentService.getAppointmentList(centreId,test,Status));
    }
}