package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Integer> {
}
