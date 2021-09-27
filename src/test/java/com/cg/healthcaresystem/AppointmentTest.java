package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.Patient;
import com.cg.healthcaresystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.cg.healthcaresystem.model.Appointment;

import static org.junit.Assert.*;
import com.cg.healthcaresystem.service.AppointmentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createTest() {


        Appointment appointment = new Appointment("2020-11-24", false);
        Assert.assertEquals(appointment, appointmentService.addAppointment(appointment));
    }

    @Test
    public void createTest1() {



        Appointment appointment = new Appointment("2021-03-12", true);
        Assert.assertEquals(appointment, appointmentService.addAppointment(appointment));
    }
}


