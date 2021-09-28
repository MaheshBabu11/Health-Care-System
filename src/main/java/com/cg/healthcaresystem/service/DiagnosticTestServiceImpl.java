package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.exception.DiagnosticTestNotFoundException;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.repository.DiagnosticCenterRepository;
import com.cg.healthcaresystem.repository.DiagnosticTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {

    @Autowired
    private DiagnosticTestRepository diagnosticTestRepository;

    @Autowired
    private DiagnosticCenterRepository diagnosticCenterRepository;

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
    public Set<DiagnosticTest> getTestOfDiagnosticCenter(int centerId){
        DiagnosticCenter c = diagnosticCenterRepository.findById(centerId).get();

        return c.getTests();
    }

    @Override
    public DiagnosticTest updateTestDetails(int id,DiagnosticTest test){
        DiagnosticTest dt = null;
        try {
        Optional<DiagnosticTest> optionalDiagnosticTest = diagnosticTestRepository.findById(id);

            if (optionalDiagnosticTest.isPresent())
                dt = optionalDiagnosticTest.get();
            else{
                throw new DiagnosticTestNotFoundException("Test not found");
            }
            dt.setTestName(test.getTestName());
            dt.setTestPrice(test.getTestPrice());
            dt.setNormalValue(test.getNormalValue());
            dt.setUnits(test.getUnits());
            return diagnosticTestRepository.save(dt);

        }catch (DiagnosticTestNotFoundException e){
            log.info("Diagnostic Test not found");
            return test;
        }
    }

    @Override
    public DiagnosticTest removeTestFormDiagnosticTest(DiagnosticTest test){
        try{
        Optional<DiagnosticTest> optionalDiagnosticTest = diagnosticTestRepository.findById(test.getId());

        if(optionalDiagnosticTest.isPresent()){
            diagnosticTestRepository.deleteById(test.getId());
            return test;
        }else{
            throw new DiagnosticTestNotFoundException("Test not found");
        }
        }catch (DiagnosticTestNotFoundException e){
            log.info("Diagnostic Test not found");
            return null;
        }

    }
}
