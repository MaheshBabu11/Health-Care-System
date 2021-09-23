package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public DiagnosticTest addTest(DiagnosticTest test){
        testRepository.save(test);
        return test;
    }
    @Override
    public DiagnosticTest updateTest(DiagnosticTest test){
        DiagnosticTest dt = null;
        Optional<DiagnosticTest> optionalDiagnosticTest = testRepository.findById(test.getId());
        if(optionalDiagnosticTest.isPresent())
            dt = optionalDiagnosticTest.get();

        dt.setTestName(test.getTestName());
        dt.setTestPrice(test.getTestPrice());
        dt.setNormalValue(test.getNormalValue());
        dt.setUnits(test.getUnits());
        return testRepository.save(dt);
    }

    @Override
    public DiagnosticTest removeTest(DiagnosticTest test){
        Optional<DiagnosticTest> optionalDiagnosticTest = testRepository.findById(test.getId());
        if(optionalDiagnosticTest.isPresent()){
            testRepository.deleteById(test.getId());
            return test;
        }else {
            return null;
        }
    }

    @Override
    public List<DiagnosticTest> viewAllTests(){
        return testRepository.findAll();
    }
}
