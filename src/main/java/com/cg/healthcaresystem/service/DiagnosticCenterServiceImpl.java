package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.model.Patient;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import com.cg.healthcaresystem.repository.DiagnosticCenterRepository;
import com.cg.healthcaresystem.repository.DiagnosticTestRepository;
import com.cg.healthcaresystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{

    @Autowired DiagnosticCenterRepository diagnosticCenterRepository;
    @Autowired DiagnosticTestRepository diagnosticTestRepository;
    @Autowired AppointmentRepository appointmentRepository;

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
        Optional<DiagnosticCenter> dc= diagnosticCenterRepository.findById(diagnosticCenterId);
        if(dc.isPresent())
            return dc.get();
        return null;
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
        DiagnosticCenter c= diagnosticCenterRepository.findById(diagnosticCenterId).get();
        Set<DiagnosticTest> tests= c.getTests();
        Iterator<DiagnosticTest> value= tests.iterator();
        int flag=0;
        for(DiagnosticTest t: tests)
        {
            if(t.getTestName().equals(testName))
            {
                flag++;
            }
        }
        if(flag>0)
        {
            DiagnosticTest test= diagnosticTestRepository.findByTestName(testName).get(0);
            return test;
            //diagnosticTestRepository.findByTestName(testName);
        }
        /*while (value.hasNext()) {
            DiagnosticTest t= value.next();
        }*/
        return null;
    }

    @Override
    public DiagnosticTest addTest( Integer diagnosticCenterId, Integer testId) {
        //DiagnosticTest t= testRepository.getById(testId);
        DiagnosticTest t=diagnosticTestRepository.findById(testId).get();
        DiagnosticCenter c=diagnosticCenterRepository.findById(diagnosticCenterId).get();
        DiagnosticCenter c1=diagnosticCenterRepository.findById(diagnosticCenterId).get();
        Set<DiagnosticTest> newTests= c.getTests();
        newTests.add(t);
        c.setTests(newTests);
        /*Set<DiagnosticCenter> newDiagnosticCenters =t.getDiagnosticCenters();
        newDiagnosticCenters.add(c1);
        t.setDiagnosticCenters(newDiagnosticCenters);*/
        //c.getTests().add(t);
        //t.getDiagnosticCenters().add(c);
        diagnosticTestRepository.saveAndFlush(t);
        diagnosticCenterRepository.saveAndFlush(c);
        return t;
    }

    @Override
    public DiagnosticCenter getDiagnosticCenter( String centerName) {
        List<DiagnosticCenter> dcs= diagnosticCenterRepository.findByName(centerName);
        return dcs.get(0);
    }

    @Override
    public List<DiagnosticCenter> removeDiagnosticCenter( Integer id) {

        //
        // for(id=53;id<68;id++) {
            DiagnosticCenter dc = null;
            Optional<DiagnosticCenter> optionalDiagnosticCenter = diagnosticCenterRepository.findById(id);
            if (optionalDiagnosticCenter.isPresent())
                dc = optionalDiagnosticCenter.get();
            diagnosticCenterRepository.deleteById(id);
            //return diagnosticCenterRepository.findAll();
        //}
        return null;
    }

    @Override
    public List<Appointment> getListOfAppointments(String centerName) {
        DiagnosticCenter dc= diagnosticCenterRepository.findByName(centerName).get(0);
        return appointmentRepository.findByDiagnosticCenter(dc);
    }

    @Override
    public DiagnosticTest getDiagnosticTestById( Integer diagnosticTestId) {
        return diagnosticTestRepository.findById(diagnosticTestId).get();
    }

}