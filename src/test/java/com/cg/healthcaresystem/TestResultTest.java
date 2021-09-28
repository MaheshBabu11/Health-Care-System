package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.TestResult;
import com.cg.healthcaresystem.service.TestResultService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestResultTest {

    @Autowired TestResultService testResultService;

    @Test
    public void createTest() {
        TestResult tr= new TestResult();
        tr.setCondition("Fever");
        tr.setTestReading(77);
        Assert.assertEquals(tr,testResultService.addTestResult(tr));
    }

    @Test
    public void updateTest() {
        TestResult tr= new TestResult();
        tr.setId(74);
        tr.setCondition("Fever");
        tr.setTestReading(99);
        testResultService.updateTestResult(tr);
        Assert.assertEquals(tr,testResultService.updateTestResult(tr));
    }
}
