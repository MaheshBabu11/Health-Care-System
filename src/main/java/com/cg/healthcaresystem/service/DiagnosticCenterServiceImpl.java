package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.model.Patient;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import com.cg.healthcaresystem.repository.DiagnosticCenterRepository;
import com.cg.healthcaresystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{

    @Autowired DiagnosticCenterRepository diagnosticCenterRepository;
    @Autowired TestRepository testRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<DiagnosticCenter> getAllDiagnosticCenters() {
        return diagnosticCenterRepository.findAll();
    }

    @Override
    public DiagnosticCenter addDiagnosticCenter( DiagnosticCenter diagnosticCenter) {
        return diagnosticCenterRepository.save( diagnosticCenter);
    }

    @Override
    public DiagnosticCenter getDiagnosticCenterById( Integer diagnosticCenterId) {
        return diagnosticCenterRepository.findById(diagnosticCenterId).get();
    }

    @Override
    public DiagnosticCenter updateDiagnosticCenter( DiagnosticCenter diagnosticCenter) {
        DiagnosticCenter dc = null;
        Optional<DiagnosticCenter> optionalDiagnosticCenter = diagnosticCenterRepository.findById(diagnosticCenter.getId());
        if (optionalDiagnosticCenter.isPresent())
            dc = optionalDiagnosticCenter.get();
        dc.setName( diagnosticCenter.getName() );
        dc.setAddress( diagnosticCenter.getAddress() );
        dc.setContactNo( diagnosticCenter.getContactNo() );
        dc.setEmail( diagnosticCenter.getEmail() );
        dc.setServicesOffered( diagnosticCenter.getServicesOffered() );
        dc.setTests( diagnosticCenter.getTests() );

        return diagnosticCenterRepository.save(dc);
    }

    @Override
    public DiagnosticTest viewTestDetails(Integer diagnosticCenterId, String testName){
        return null;
    }

    @Override
    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId) {
        DiagnosticTest t= testRepository.getById(testId);
        DiagnosticCenter c=diagnosticCenterRepository.getById(diagnosticCenterId);
        c.getTests().add(t);
        t.getDiagnosticCenters().add(c);
        testRepository.saveAndFlush(t);
        diagnosticCenterRepository.saveAndFlush(c);
        return t;
    }

    @Override
    public DiagnosticCenter getDiagnosticCenter( String centerName) {
        List<DiagnosticCenter> dcs= diagnosticCenterRepository.findByName(centerName);
        return dcs.get(0);
    }

    @Override
    public DiagnosticCenter removeDiagnosticCenter( Integer id) {
        DiagnosticCenter dc = null;
        Optional<DiagnosticCenter> optionalDiagnosticCenter = diagnosticCenterRepository.findById(id);
        if (optionalDiagnosticCenter.isPresent())
            dc = optionalDiagnosticCenter.get();
        diagnosticCenterRepository.deleteById(id);
        return  dc;
    }

    @Override
    public List<Appointment> getListOfAppointments(String centerName) {
        DiagnosticCenter dc= diagnosticCenterRepository.findByName(centerName).get(0);
        return appointmentRepository.findByDiagnosticCenter(dc);
    }

}
