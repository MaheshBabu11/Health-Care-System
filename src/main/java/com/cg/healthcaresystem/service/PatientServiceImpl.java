package com.cg.healthcaresystem.service;


import com.cg.healthcaresystem.exception.PatientNotFoundException;
import com.cg.healthcaresystem.model.*;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import com.cg.healthcaresystem.repository.PatientRepository;
import com.cg.healthcaresystem.repository.TestResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired private TestResultRepository testResultRepository;
    @Autowired private PatientRepository patientRepository;
    @Autowired private AppointmentRepository appointmentRepository;

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
    public Patient updatePatientDetails(int id, Patient patient) {
        Patient pt = null;
        try {
            Optional<Patient> optionalPatient = patientRepository.findById(id);

            if (optionalPatient.isPresent())
                pt = optionalPatient.get();
            else {
                throw new PatientNotFoundException("Patient not found");
            }
            pt.setName(patient.getName());
            pt.setPhoneNo(patient.getPhoneNo());
            pt.setAge(patient.getAge());
            pt.setGender(patient.getGender());

            return patientRepository.save(pt);
        }
        catch (PatientNotFoundException e){
            log.info("Patient not found");
            return null;
        }
    }

    @Override
    public Patient viewPatient(int id) {
        Patient patient=null;
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent())
            patient = optionalPatient.get();
        if(patient==null)
            System.out.println("null");
        return patient;
    }

    @Override
    public Patient getAllTestResult(String patientUserName) {
        Patient patient = patientRepository.findByName(patientUserName).get(0);
        return patient;

    }
    @Override
    public TestResult viewTestResult(Integer testResultId) {

        return testResultRepository.findById(testResultId).get();
    }


}

