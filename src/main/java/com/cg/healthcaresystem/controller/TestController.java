package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("add test")
    @PostMapping("/addtest")
    public ResponseEntity<DiagnosticTest> addTest(@Valid @RequestBody DiagnosticTest test){
        DiagnosticTest newTest = testService.addTest(test);
        log.info("New test created");
        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
    }

    @ApiOperation("update test")
    @PutMapping("/updatetest")
    public ResponseEntity<DiagnosticTest> updateTest(@Valid @RequestBody DiagnosticTest test){
        return null;
    }

    @ApiOperation("delete test")
    @DeleteMapping("/removetest")
    public ResponseEntity<DiagnosticTest>  removeTest(@Valid @RequestBody DiagnosticTest test){

        return null;
    }

    @ApiOperation("view all the test")
    @GetMapping("/viewalltest")
    public List<DiagnosticTest> viewAllTests(){
        log.info("View all tests");
        return testService.viewAllTests();
    }
}
