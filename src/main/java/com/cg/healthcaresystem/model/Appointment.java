package com.cg.healthcaresystem.model;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message="Please enter your appointment date")
    private LocalDate date;
    @NotNull(message="Please enter the approval status")
    private Boolean ApprovalStatus;
    @OneToOne(targetEntity = Diagonistic.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "", referencedColumnName = "id")
    private Set<DiagonisticCenter> DiagonisticCenter Set;
    @OneToMany(targetEntity = TestResult.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "", referencedColumnName = "id")
    private Set<TestResult> TestResult Set;
    @OneToOne(targetEntity = patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "", referencedColumnName = "id")
    @OneToMany-(targetEntity = DiagonisticTest.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "", referencedColumnName = "id")
    private Set<DiagonisticTest> DiagonisticTest Set;







}
}



