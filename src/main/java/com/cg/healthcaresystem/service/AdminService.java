package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public Admin registerAdmin(Admin admin);
}
