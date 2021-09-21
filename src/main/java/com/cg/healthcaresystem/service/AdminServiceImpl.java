package com.cg.healthcaresystem.service;

import com.cg.healthcaresystem.model.Admin;
import com.cg.healthcaresystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin registerAdmin(Admin admin) {
        adminRepository.save(admin);
        return admin;
    }
}
