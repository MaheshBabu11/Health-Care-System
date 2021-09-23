package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment,Integer> {

    public Patient findByPatient(Patient patient);
    public List<Appointment> findByDiagnosticCenter(DiagnosticCenter diagnosticCenter);
}
