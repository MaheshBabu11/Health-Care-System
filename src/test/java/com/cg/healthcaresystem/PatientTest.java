package com.cg.healthcaresystem;


import com.cg.healthcaresystem.model.Patient;


import static org.junit.Assert.*;

import com.cg.healthcaresystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {
@Autowired
 private PatientService patientService;


    @Test
    public void test1() {

        Patient p=new Patient();
        p.setName("gaurav");
        p.setGender("male");
        p.setAge(22);
        p.setPhoneNo("632732737");
        assertEquals(p,patientService.registerPatient(p));

    }

}