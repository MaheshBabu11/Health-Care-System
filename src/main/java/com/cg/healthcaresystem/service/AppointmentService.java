package com.cg.healthcaresystem.service;
import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
 @Service

public interface AppointmentService {
    public Appointment addAppointment(Appointment appointment);

    public Set<Appointment>  viewAppointment(String patientName);

    public Appointment viewAppointment(int Appointment);

    public Appointment updateAppointment(Appointment appointment);

    public List<Appointment> getAppointment(int centreid,String test,int status);

    public Appointment removeAppointment(Appointment appointment);


}
