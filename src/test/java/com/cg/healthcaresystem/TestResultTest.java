package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.TestResult;
import com.cg.healthcaresystem.service.TestResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestResultTest {

    @Autowired TestResultService testResultService;

    @Test
    public void createTest() {
        TestResult tr= new TestResult();
        tr.setCondition("");
        tr.setTestReading(0);
    }
}
