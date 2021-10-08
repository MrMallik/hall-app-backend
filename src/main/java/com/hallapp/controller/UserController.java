package com.hallapp.controller;

import com.hallapp.controller.RoomController;
import com.hallapp.model.BookingModel;
import com.hallapp.model.UserBookingModel;
import com.hallapp.model.UserModel;
import com.hallapp.service.BookingService;
import com.hallapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

//    @GetMapping("/getUserBookings/{id}")
//    public List<BookingModel> getUserBookings(@PathVariable String id){
//        UserModel currUser = userService.getUserByEmail(id);
//        return currUser.getBookings();
//    }

    @PostMapping("/editProfile/")
    public UserModel editProfile(@RequestBody UserModel user){
        UserModel currUser = userService.getUserByEmail(user.getEmail());
        currUser.setUsername(user.getUsername());
        currUser.setUserRole(user.getUserRole());
        currUser.setAge(user.getAge());
        currUser.setPassword(user.getPassword());
        currUser.setMobileNumber(user.getMobileNumber());

        return userService.saveUser(currUser);
    }

    @GetMapping("/getUserBookings/{userID}")
    public List<BookingModel> getUserBookings(@PathVariable String userID){
        return bookingService.getBookingByUserID(userID);
    }


}
