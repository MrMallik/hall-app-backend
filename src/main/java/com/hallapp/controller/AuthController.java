package com.hallapp.controller;

import com.hallapp.model.AdminModel;
import com.hallapp.model.LoginModel;
import com.hallapp.model.UserModel;
import com.hallapp.service.AdminService;
import com.hallapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/isUserPresent")
    public boolean isUserPresent(@RequestBody LoginModel login){
        UserModel existingUser = userService.getUserByEmail(login.getEmail());

        if(existingUser != null) {

            return existingUser.getEmail().equals(login.getEmail()) &&
                    existingUser.getPassword().equals(login.getPassword());
        }

        else{
            return false;
        }




    }

    @GetMapping("/isAdminPresent")
    public boolean isAdminPresent(@RequestBody AdminModel admin){
        AdminModel existingAdmin = adminService.getProfile(admin.getEmail());

        if(existingAdmin != null)
            return existingAdmin.getEmail() == admin.getEmail() &&
                    existingAdmin.getPassword() == admin.getPassword();
        else
            return false;
    }

    @PostMapping("/addUser")
    public void saveUser(@RequestBody UserModel user){

        //TODO : Make sure only roles with "user" is added to user

        user.setUserRole("user");
        userService.saveUser(user);
    }

    @PostMapping("/addAdmin")
    public void saveAdmin(@RequestBody AdminModel admin){
        admin.setUserRole("admin");
        adminService.saveAdmin(admin);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody UserModel user){ userService.deleteUserById(user.getEmail());}


}
