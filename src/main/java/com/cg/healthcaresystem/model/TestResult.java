package com.cg.healthcaresystem.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TestResult")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please enter test reading")
    private double testReading;
    @NotNull(message = "please enter condition")
    private String condition;
    @NotNull(message = "please enter appointment details")
    @OneToOne(targetEntity = Appointment.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "ap_res", referencedColumnName = "id")
    private Appointment appointment;
}

