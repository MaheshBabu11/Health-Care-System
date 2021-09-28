package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.Patient;
import com.cg.healthcaresystem.model.TestResult;
import com.cg.healthcaresystem.service.PatientService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/getall")
    @ApiOperation("Fetch All Patient Records")
    public List<Patient> getPatient() {
        log.info("INSIDE getPatient!!");
        return patientService.getAll();
    }
    @ApiOperation("Save a New Patient Record!")
    @PostMapping("/register")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        log.info("Inside Patient %s", patient);
        Patient pt = patientService.registerPatient(patient);
        return new ResponseEntity<>(pt, HttpStatus.CREATED);
    }
    @ApiOperation("Get A Patient By ID")
    @GetMapping("/view/{id}")
    public Patient fetchById(@PathVariable int id) {
        return patientService.viewPatient(id);
    }
    @ApiOperation("Update An Existing Patient")
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,@Valid @RequestBody Patient patient){
        log.info("Updating a patient!!");
        patientService.updatePatientDetails(id, patient);
    }
    @GetMapping("/getAllTestResult/{patientUserName}")
    public ResponseEntity<Patient> getAllTestResult(@PathVariable String patientUserName)
    {
        return ResponseEntity.ok(this.patientService.getAllTestResult(patientUserName));
    }

    @GetMapping("/viewTestResult/{id}")
    public ResponseEntity<TestResult> viewTestResult(@PathVariable Integer id) {
        return ResponseEntity.ok(this.patientService.viewTestResult(id));
    }

}
