package com.cg.healthcaresystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "Diagnostic_Center")
public class DiagnosticCenter {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    @NotNull(message = "Please Enter Diagnostic Center Name:")
    private String name;
    @NotNull(message = "Please Enter Diagnostic Center Contact Number:")
    private String contactNo;
    @NotNull(message = "Please Enter Diagnostic Center Address:")
    private String address;
    @NotNull(message = "Please Enter Diagnostic Center Email:")
    private String email;

    //@NotNull(message = "Please Enter Services Offered:")
    private List<String> servicesOffered;

    //@NotNull(message = "Please Enter Diagnostic Tests:")
    private Set<DiagnosticTest> tests;
}
