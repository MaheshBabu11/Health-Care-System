package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest,Integer> {
}
