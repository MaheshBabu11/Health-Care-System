package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public DiagnosticTest removeTest(DiagnosticTest test){
        return null;
    }

    @Override
    public List<DiagnosticTest> viewAllTests(){
        return testRepository.findAll();
    }
}
