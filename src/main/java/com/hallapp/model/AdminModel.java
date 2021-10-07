package com.hallapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin_tbl")
public class AdminModel {
    @Id
    String email;
    String password;
    String mobileNumber;
    String sellerName;
    String userRole;
    String companyName;
    String companyImageURL;
    String companyAddress;
    int earnings;
}
