package com.hallapp.service;

import com.hallapp.model.AdminModel;
import com.hallapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminModel editAdmin(AdminModel admin){

        //TODO : Check why this method is generating an internal server error
        //Functionality is OKAY tho

        AdminModel currAdmin = adminRepository.getById(admin.getEmail());

        currAdmin.setPassword(admin.getPassword());
        currAdmin.setCompanyAddress(admin.getCompanyAddress());
        currAdmin.setMobileNumber(admin.getMobileNumber());
        currAdmin.setSellerName(admin.getSellerName());
        currAdmin.setCompanyName(admin.getCompanyName());
        currAdmin.setCompanyImageURL(admin.getCompanyImageURL());
        currAdmin.setEarnings(admin.getEarnings());

        adminRepository.save(admin);

        return currAdmin;
    }

    public AdminModel getProfile(String adminEmail){
        return adminRepository.getById(adminEmail);
    }

    public AdminModel saveAdmin(AdminModel admin){
        return adminRepository.save(admin);
    }
}
