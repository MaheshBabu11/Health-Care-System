package com.cg.healthcaresystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@Table(name = "DiagnosticTest")
public class DiagnosticTest {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    @NotNull(message = "Please Enter Diagnostic Test Name:")
    private String testName;
    @NotNull(message = "Please Enter Diagnostic Test Price:")
    private double testPrice;
    @NotNull(message = "Please Enter Diagnostic Test Normal Value:")
    private String normalValue;

    @NotNull(message = "Please Enter Diagnostic Center Units:")
    private String units;

    //@NotNull(message= "Please Enter Diagnostic Test Centers:")
    @OneToMany(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "", referencedColumnName = "id")
    private Set<DiagnosticCenter> diagnosticCenters;


}
