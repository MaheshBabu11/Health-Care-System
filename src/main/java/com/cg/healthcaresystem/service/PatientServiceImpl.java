package com.cg.healthcaresystem.service;


import com.cg.healthcaresystem.model.*;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import com.cg.healthcaresystem.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Patient> getAll() {
        System.out.println("PatientRepository Child Class Created By Spring Boot: " + patientRepository.getClass().getName());
        return patientRepository.findAll();
    }

    @Override
    public Patient registerPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void updatePatientDetails(int id, Patient patient) {
        Patient pt = null;
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent())
            pt = optionalPatient.get();
        pt.setName(patient.getName());
        pt.setPhoneNo(patient.getPhoneNo());
        pt.setAge(patient.getAge());
        pt.setGender(patient.getGender());

        patientRepository.save(pt);
    }

    @Override
    public Patient viewPatient(int id) {
        Patient patient=null;
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent())
            patient = optionalPatient.get();
        return patient;
    }

    @Override
    public Patient getAllTestResult(String patientUserName) {
        Patient patient = patientRepository.findByName(patientUserName);
        log.info(String.valueOf(patient));
        return null;

//        Optional<Appointment> appointment = appointmentRepository.findById(patient.getPatientid());
//        if (appointment.isPresent())
//            return appointment;
//        else
//            return null;
    }

    @Override
    public Patient viewTestResult(int testResultId) {
       /* Patient c= PatientRepository.findById(testResultId).get();
        Set<DiagnosticTest> tests= c.getTests();
        Iterator<PatientTest> value= tests.iterator();
        int flag=0;
        for(PatientTest t: tests)
        {
            if(t.getTestName().equals(testName))
            {
                flag++;
            }
        }
        if(flag>0)
        {
            PatientTest test= diagnosticTestRepository.findByTestName(testName).get(0);
            return test;

        } */

        return null;
    }


}

