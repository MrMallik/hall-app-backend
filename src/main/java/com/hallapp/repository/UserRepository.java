package com.hallapp.repository;

import com.hallapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, String> {

    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
