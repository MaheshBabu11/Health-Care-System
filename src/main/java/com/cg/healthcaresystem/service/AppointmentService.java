package com.cg.healthcaresystem.service;
import com.cg.healthcaresystem.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcaresystem.exception.DiagnosticTestNotFoundException;
import com.cg.healthcaresystem.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service

public interface AppointmentService {
    public Appointment addAppointment(Appointment appointment);

    public Set<Appointment>  viewAppointments(String patientName);

    public Optional<Appointment> viewAppointment(int Appointment);

    public Appointment updateAppointment(Appointment appointment);

    public List<Appointment> getAppointmentList(int centreid,String test,boolean status);

    public Appointment removeAppointment(Appointment appointment);


    public Appointment addAppointment(int patientId, int testCenterid, int testId,String date) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;
}