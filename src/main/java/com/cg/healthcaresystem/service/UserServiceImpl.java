package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.User;
import com.cg.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Override
    public User validateUser(String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userRepository.exists(Example.of(user)))
            return user;
        else
            return null;

    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User removeUser(User user) {
        return null;
    }
}
