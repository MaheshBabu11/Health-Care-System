package com.cg.healthcaresystem.controller;

import com.cg.healthcaresystem.model.User;
import com.cg.healthcaresystem.service.PatientService;
import com.cg.healthcaresystem.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;
    private PatientService patientService;

    @GetMapping("/welcome")
    public String user(){
        return ("<h1> Welcome User</h1>");
    }

    @ApiOperation("Add a new  User")
    @PostMapping("/register")
    public ResponseEntity<User> regsiterUser(@Valid @RequestBody User user) {
        User userNew = userService.addUser(user);
        log.info("Added a new User");
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> validateUser(@RequestBody String userName, String password) {
        User user = userService.validateUser(userName, password);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/remove")
    public ResponseEntity<User> removeUser(@RequestBody User user) {
        User userRemoved = userService.removeUser(user);
        if (userRemoved != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }
}
