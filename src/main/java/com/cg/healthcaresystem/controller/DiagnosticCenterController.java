package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.service.DiagnosticCenterService;
import com.cg.healthcaresystem.service.DiagnosticTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/DiagnosticCenter")
public class DiagnosticCenterController {
    @Autowired
    private DiagnosticCenterService diagnosticCenterService;

    @Autowired
    private DiagnosticTestService diagnosticTestService;

    @PostMapping("/add")
    public ResponseEntity<DiagnosticCenter> add(@RequestBody DiagnosticCenter diagnosticCenter)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.addDiagnosticCenter(diagnosticCenter));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllDiagnosticCenters()
    {
        return ResponseEntity.ok(this.diagnosticCenterService.getAllDiagnosticCenters());

    }

    @GetMapping("/getbyid/{id}")
    public DiagnosticCenter fetchById(@PathVariable Integer id) {
        return diagnosticCenterService.getDiagnosticCenterById(id);

    }

    @PutMapping("/update")
    public ResponseEntity<DiagnosticCenter> update(@RequestBody DiagnosticCenter diagnosticCenter)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter));
    }

    @GetMapping("/viewtest/{centerId}/{testName}")
    public ResponseEntity<DiagnosticTest> viewTestDetails(@PathVariable Integer centerId,@PathVariable String testName)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.viewTestDetails(centerId,testName));
    }

    @PostMapping("/addtest/{diagnosticcenterId}/{testid}")
    public ResponseEntity<DiagnosticTest> addTest(@PathVariable Integer diagnosticcenterId, @PathVariable Integer testid)
    {
        return ResponseEntity.ok(this.diagnosticCenterService.addTest(diagnosticcenterId,testid));
    }

    @GetMapping("/getbyname/{name}")
    public DiagnosticCenter fetchByName(@PathVariable String name) {
        return diagnosticCenterService.getDiagnosticCenter(name);
    }

    @DeleteMapping("remove/{id}")
    public List<DiagnosticCenter> removeDiagnosticCenter(@PathVariable Integer id)
    {
        return diagnosticCenterService.removeDiagnosticCenter(id);
    }

    @GetMapping("/gettestbyid/{id}")
    public DiagnosticTest fetchTestById(@PathVariable Integer id) {
        return diagnosticCenterService.getDiagnosticTestById(id);

    }

}