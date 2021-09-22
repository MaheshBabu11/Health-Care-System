package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
