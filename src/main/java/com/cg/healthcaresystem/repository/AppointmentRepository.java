package com.cg.healthcaresystem.repository;

import com.cg.healthcaresystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment,Integer> {

}
