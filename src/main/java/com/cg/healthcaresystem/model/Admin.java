package com.cg.healthcaresystem.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Admin_Table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "please enter username")
    private String name;
    @NotNull(message = "please enter password")
    private String password;

}

