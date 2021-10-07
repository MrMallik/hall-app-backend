package com.hallapp.service;

import com.hallapp.model.UserModel;
import com.hallapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public List<UserModel> saveUsers(List<UserModel> users){
        return userRepository.saveAll(users);
    }

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserByName(String username){
        return userRepository.findByUsername(username);
    }

    public UserModel getUserByEmail(String email){ return userRepository.findByEmail(email);}

    public String deleteUserById(String email){
        userRepository.deleteById(email);
        return "User with email id : " + email + " has been removed!";
    }

    public UserModel updateUserById(UserModel user){
      UserModel existingUser = userRepository.findByEmail(user.getEmail());
      existingUser.setUsername(user.getUsername());
      existingUser.setMobileNumber(user.getMobileNumber());

      return userRepository.save(existingUser);
    }
}
