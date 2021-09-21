package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.DiagnosticTest;

import java.util.List;

public interface DiagnosticTestService {
    public List<DiagnosticTest> getAllTest();

    public DiagnosticTest addNewTest(DiagnosticTest test);

    public List<DiagnosticTest> getTestOfDiagnosticCenter(int centerId);

    public DiagnosticTest updateTestDetails(DiagnosticTest test);

    public DiagnosticTest removeTestFormDiagnosticCenter(int centerId, DiagnosticTest test);
}
