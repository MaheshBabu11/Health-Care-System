package com.cg.healthcaresystem.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Test_Result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please enter test reading")
    private double testReading;
    @NotNull(message = "please enter condition")
    private String condition;
    @NotNull(message = "please enter appointment details")
    private Appointment appointment;
}
