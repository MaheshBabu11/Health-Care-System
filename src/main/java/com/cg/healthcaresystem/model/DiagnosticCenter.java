package com.cg.healthcaresystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="DiagnosticCenter")
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

    @ElementCollection
    private List<String> servicesOffered;

    @OneToMany(targetEntity = DiagnosticTest.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ct_fk", referencedColumnName = "id")
    private Set<DiagnosticTest> tests;

    public DiagnosticCenter(String name, String contactNo, String address, String email) {
        this.name=name;
        this.contactNo=contactNo;
        this.address=address;
        this.email=email;
    }

}
