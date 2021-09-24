package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.TestResult;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TestResultService {
    TestResult addTestResult(TestResult tr);
    TestResult updateTestResult(TestResult testResult);
    TestResult removeTestResult(Integer id);
    Set<TestResult> viewResultByAppointment(Integer appointmentId);
}
