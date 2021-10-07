package com.hallapp.controller;

import com.hallapp.model.AdminModel;
import com.hallapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/editAdmin")
    public AdminModel editAdmin(@RequestBody AdminModel admin){
        return adminService.editAdmin(admin);
    }

    @GetMapping("/getAdmin/{id}")
    public AdminModel getAdmin(@PathVariable String email){
        return adminService.getProfile(email);
    }
}
