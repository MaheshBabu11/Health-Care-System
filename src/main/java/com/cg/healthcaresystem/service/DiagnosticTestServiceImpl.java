package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.DiagnosticTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {

    @Autowired
    private DiagnosticTestRepository diagnosticTestRepository;

    @Override
    public List<DiagnosticTest> getAllTest(){
        return diagnosticTestRepository.findAll();
    }

    @Override
    public DiagnosticTest addNewTest(DiagnosticTest test){
        diagnosticTestRepository.save(test);
        return test;
    }

    @Override
    public List<DiagnosticTest> getTestOfDiagnosticCenter(int centerId){

        return null;
    }

    @Override
    public DiagnosticTest updateTestDetails(DiagnosticTest test){
        
        return null;
    }

    @Override
    public DiagnosticTest removeTestFormDiagnosticCenter(int centerId, DiagnosticTest test){
        return null;
    }
}
