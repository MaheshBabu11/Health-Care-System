package com.cg.healthcaresystem;


import com.cg.healthcaresystem.model.Patient;


import static org.junit.Assert.*;

import com.cg.healthcaresystem.service.PatientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {
@Autowired
 private PatientService patientService;


    @Test
    public void createTest() {

        Patient patient=new Patient("Mahesh","9605431794",25,"male");

       Assert.assertEquals(patient,patientService.registerPatient(patient));


    }
    @Test
    public void createTest2() {

        Patient patient=new Patient("kaushik","860522294",21,"female");

        Assert.assertEquals(patient,patientService.registerPatient(patient));


    }
}