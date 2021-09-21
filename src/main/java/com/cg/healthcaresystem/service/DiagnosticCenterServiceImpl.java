package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.DiagnosticCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{

    @Autowired DiagnosticCenterRepository diagnosticCenterRepository;

    @Override
    public List<DiagnosticCenter> getAllDiagnosticCenters() {
        return null;
    }

    @Override
    public DiagnosticCenter addDiagnosticCenter( DiagnosticCenter diagnosticCenter) {
        return null;
    }

    @Override
    public DiagnosticCenter getDiagnosticCenterById( Integer diagnosticCenterId) {
        return null;
    }

    @Override
    public DiagnosticCenter updateDiagnosticCenter( DiagnosticCenter diagnosticCenter) {
        return null;
    }

    @Override
    public DiagnosticTest viewTestDetails(Integer diagnosticCenterId, String testName){
        return null;
    }

    @Override
    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId) {
        return null;
    }

    @Override
    public DiagnosticCenter getDiagnosticCenter( String centerName) {
        return null;
    }

    @Override
    public DiagnosticCenter removeDiagnosticCenter( Integer id) {
        return null;
    }

    @Override
    public List<Appointment> getListOfAppointments(String centerName) {
        return null;
    }

}
