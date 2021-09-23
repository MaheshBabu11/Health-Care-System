package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosticCenterService {

    public List<DiagnosticCenter> getAllDiagnosticCenters();

    public DiagnosticCenter addDiagnosticCenter( DiagnosticCenter diagnosticCenter);

    public DiagnosticCenter getDiagnosticCenterById( Integer diagnosticCenterId);

    public DiagnosticCenter updateDiagnosticCenter( DiagnosticCenter diagnosticCenter);

    public DiagnosticTest viewTestDetails( Integer diagnosticCenterId, String testName);

    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId);

    public DiagnosticCenter getDiagnosticCenter( String centerName);

    public List<DiagnosticCenter> removeDiagnosticCenter( Integer id);

    public List<Appointment> getListOfAppointments(String centerName);

    //Temp
    public DiagnosticTest getDiagnosticTestById( Integer diagnosticTestId);

}
