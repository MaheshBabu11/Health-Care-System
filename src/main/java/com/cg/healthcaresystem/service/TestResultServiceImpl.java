package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.TestResult;
import com.cg.healthcaresystem.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TestResultServiceImpl implements TestResultService{

    @Autowired TestResultRepository testResultRepository;

    @Override
    public TestResult addTestResult(TestResult tr) {
        return testResultRepository.save(tr);
    }

    @Override
    public TestResult updateTestResult(TestResult testResult) {

        /*DiagnosticCenter dc = null;
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
        */
        TestResult tr=null;
        Optional<TestResult> optionalTestResult= testResultRepository.findById(testResult.getId());
        if(optionalTestResult.isPresent())
            tr= optionalTestResult.get();
        tr.setCondition(testResult.getCondition());
        tr.setTestReading(testResult.getTestReading());
        tr.setAppointment(null);


        return testResultRepository.save(tr);
    }

    @Override
    public TestResult removeTestResult(Integer id) {
        TestResult tr= testResultRepository.findById(id).get();
        TestResult trCopy=null;
        trCopy.setId(tr.getId());
        trCopy.setCondition(tr.getCondition());
        trCopy.setTestReading(tr.getTestReading());
        trCopy.setAppointment(tr.getAppointment());
        testResultRepository.deleteById(id);
        return  trCopy;
    }

    @Override
    public Set<TestResult> viewResultByAppointment(Integer appointmentId) {
        return null;
    }
}
