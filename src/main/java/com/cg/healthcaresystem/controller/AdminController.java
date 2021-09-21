package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.Admin;
import com.cg.healthcaresystem.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("Add a new Admin User")
    @PostMapping("/register")
    public ResponseEntity<Admin> regsiterAdmin(@Valid @RequestBody Admin admin)
    {
        Admin adminNew=adminService.registerAdmin(admin);
        log.info("Added new Admin");
        return new ResponseEntity<>(adminNew, HttpStatus.CREATED);
    }
}
