package com.cg.healthcaresystem.security;

import com.cg.healthcaresystem.model.User;
import com.cg.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user=userRepository.findByUsername(username);
       user.orElseThrow(()->new UsernameNotFoundException("No found : "+username));
       return user.map(MyUserDetails::new).get();
    }
}
