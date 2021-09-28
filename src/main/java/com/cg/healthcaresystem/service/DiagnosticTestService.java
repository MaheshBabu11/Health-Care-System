package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface DiagnosticTestService {
    public List<DiagnosticTest> getAllTest();

    public DiagnosticTest addNewTest(DiagnosticTest test);

    public Set<DiagnosticTest> getTestOfDiagnosticCenter(int centerId);

    public DiagnosticTest updateTestDetails(DiagnosticTest test);

    public DiagnosticTest removeTestFormDiagnosticTest(DiagnosticTest test);
}
