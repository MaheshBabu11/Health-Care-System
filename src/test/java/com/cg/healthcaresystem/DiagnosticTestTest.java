package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.service.DiagnosticTestService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class DiagnosticTestTest {

    @Autowired
    private DiagnosticTestService diagnosticTestService;

    @Test
    public void addTestPass(){
        DiagnosticTest test = new DiagnosticTest("140 mg/l","Suger",500,"mg");

        Assert.assertEquals(test,diagnosticTestService.addNewTest(test));
    }
}
