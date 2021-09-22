package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    public List<Patient> getAll();

    public Patient registerPatient(Patient patient);
    void updatePatientDetails(int id,Patient patient);
    Patient viewPatient(int id, Patient patient);
    public Patient getAllTestResult(String patientUserName);
    public Patient viewTestResult(int testResultId);


}
