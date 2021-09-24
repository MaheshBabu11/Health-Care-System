package com.cg.healthcaresystem.controller;


import com.cg.healthcaresystem.model.TestResult;
import com.cg.healthcaresystem.service.TestResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("TestResult")
public class TestResultController {

    @Autowired private TestResultService testResultService;

    @PostMapping("/add")
    public ResponseEntity<TestResult> addTestResult(@RequestBody TestResult testResult)
    {
        return ResponseEntity.ok(this.testResultService.addTestResult(testResult));
    }

    @PutMapping("/update")
    public ResponseEntity<TestResult> updateTestResult(@RequestBody TestResult testResult)
    {
        return ResponseEntity.ok(this.testResultService.updateTestResult(testResult));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TestResult> deleteTestResult(@PathVariable Integer id)
    {
        return ResponseEntity.ok(this.testResultService.removeTestResult(id));
    }


}
