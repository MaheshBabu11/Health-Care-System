package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.DiagnosticTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<DiagnosticTest,Integer> {
}
