package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.service.DiagnosticTestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("DiagnosticTest")
public class DiagnosticTestController {
    @Autowired
    private DiagnosticTestService diagnosticTestService;

    @ApiOperation("Add new Test")
    @PostMapping("/addtest")
    public ResponseEntity<DiagnosticTest> addtest(@Valid @RequestBody DiagnosticTest test){
        DiagnosticTest newTest = diagnosticTestService.addNewTest(test);
        log.info("Added new test");
        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
    }

}
