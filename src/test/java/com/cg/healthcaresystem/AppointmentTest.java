package com.cg.healthcaresystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.service.AppointmentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

@Rollback(value = true)
@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void addAppointmentPassTest() {


        Appointment appointment = new Appointment("2020-11-24", false);
        Appointment appointment2 = new Appointment("2020-11-24", true);
        Assert.assertEquals(appointment, appointmentService.addAppointment(appointment));
        Assert.assertEquals(appointment2, appointmentService.addAppointment(appointment2));
        Assert.assertNotEquals(false, appointment);


    }

    @Test
    public void addAppointmentFailTest() {



        Appointment appointment = new Appointment("2021-03-12",false );
        Appointment appointment1 = new Appointment(null, true);

        Assert.assertEquals(appointment, appointmentService.addAppointment(appointment));
        Assert.assertEquals(appointment1, appointmentService.addAppointment(appointment1));
       Assert.assertEquals(false, appointment);
    }
    @Test
    public void getAllAppointment(){

    }
    @Test
    public void getAppointmentByid()
    {

    }

    }



