package com.hallapp.repository;

import com.hallapp.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<AdminModel, String> {
}
