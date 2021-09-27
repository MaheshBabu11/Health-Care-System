package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;

import com.cg.healthcaresystem.model.DiagnosticTest;
import com.cg.healthcaresystem.service.DiagnosticCenterService;

import com.cg.healthcaresystem.service.TestService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DiagnosticCenterTest {

    @Autowired DiagnosticCenterService diagnosticCenterService;
    @Autowired TestService testService;

    @Test
    public void getAllDiagnosticCentersTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        diagnosticCenterService.addDiagnosticCenter(dc);
        Assert.assertNotNull(diagnosticCenterService.getAllDiagnosticCenters());
    }

    @Test
    public void addDiagnosticCenterTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        Assert.assertEquals(dc,diagnosticCenterService.addDiagnosticCenter(dc));
    }

    @Test
    public void getDiagnosticCenterByIdTest(){


        DiagnosticCenter dc= diagnosticCenterService.getDiagnosticCenterById(1);
        Assert.assertEquals("Sen Diagnostics",dc.getName());

    }

    @Test
    public void updateDiagnosticCenterTest() {
        DiagnosticCenter diagnosticCenter= diagnosticCenterService.getDiagnosticCenterById(4);
        diagnosticCenter.setName("Eastern Diagnostics");
        DiagnosticCenter dc = diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter);
        Assert.assertEquals(dc.getName(),diagnosticCenter.getName());


    }

    @Test
    public void viewTestDetailsTest(){
        //Integer i=7;
        //DiagnosticTest dt= diagnosticCenterService.viewTestDetails(i,"ESR");
        //Assert.assertNotNull(dt);
    }

    @Test
    public void addTestTest( ) {

    }

    @Test
    public void getDiagnosticCenterTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        Assert.assertEquals(dc.getName(),"HC Diagnostic");

    }

    @Test
    public void removeDiagnosticCenterTest() {

    }

    @Test
    public void getListOfAppointmentsTest() {

    }


}
