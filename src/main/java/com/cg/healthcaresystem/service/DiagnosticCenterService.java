package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcaresystem.exception.DiagnosticTestNotFoundException;
import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosticCenterService {

    public List<DiagnosticCenter> getAllDiagnosticCenters();

    public DiagnosticCenter addDiagnosticCenter( DiagnosticCenter diagnosticCenter);

    public DiagnosticCenter getDiagnosticCenterById( Integer diagnosticCenterId) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;

    public DiagnosticCenter updateDiagnosticCenter( DiagnosticCenter diagnosticCenter) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException;

    public DiagnosticTest viewTestDetails( Integer diagnosticCenterId, String testName);

    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId);

    public DiagnosticCenter getDiagnosticCenter( String centerName);

    public List<DiagnosticCenter> removeDiagnosticCenter( Integer id);

    public List<Appointment> getListOfAppointments(String centerName);

    //Temp
    public DiagnosticTest getDiagnosticTestById( Integer diagnosticTestId);

}