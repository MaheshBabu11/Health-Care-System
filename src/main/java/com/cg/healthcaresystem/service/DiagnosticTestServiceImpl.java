package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.DiagnosticTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        DiagnosticTest dt = null;
        Optional<DiagnosticTest> optionalDiagnosticTest = diagnosticTestRepository.findById(test.getId());
        if(optionalDiagnosticTest.isPresent())
            dt = optionalDiagnosticTest.get();

        dt.setTestName(test.getTestName());
        dt.setTestPrice(test.getTestPrice());
        dt.setNormalValue(test.getNormalValue());
        dt.setUnits(test.getUnits());
        return null;
    }

    @Override
    public DiagnosticTest removeTestFormDiagnosticCenter(int centerId, DiagnosticTest test){
        Optional<DiagnosticTest> optionalDiagnosticTestTemp = diagnosticTestRepository.findById(test.getId());
        if(optionalDiagnosticTestTemp.isPresent()){
            diagnosticTestRepository.deleteById(test.getId());
            return test;
        }else {
            return null;
        }
    }
}
