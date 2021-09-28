package com.cg.healthcaresystem;


import com.cg.healthcaresystem.model.Patient;


import static org.junit.Assert.*;

import com.cg.healthcaresystem.service.PatientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class PatientTest {
@Autowired
 private PatientService patientService;


    @Test
    public void createTest() {

        Patient patient=new Patient("grv","9605431794",25,"male");
        Patient patient2=new Patient("rohini","34566777",31,"female");

       Assert.assertEquals(patient,patientService.registerPatient(patient));
        Assert.assertEquals(patient2,patientService.registerPatient(patient2));

    }
    @Test
    public void createTest2() {

        Patient patient=new Patient("grv","860522294",null,null);
        Patient patient2=new Patient(null,"860522294",null,"male");
        Patient patient3=new Patient("grov",null,21,null);
        Assert.assertEquals(patient,patientService.registerPatient(patient));
        Assert.assertEquals(patient,patientService.registerPatient(patient2));
        Assert.assertEquals(patient,patientService.registerPatient(patient3));

    }
}