package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User validateUser(String username,String password);
    public User addUser(User user);
    public User removeUser(User user);
}
