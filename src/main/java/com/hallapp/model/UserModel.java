package com.hallapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class UserModel {

    @Id
    String email;
    String password;
    String username;
    String mobileNumber;
    int age;
    String userRole;
    List<BookingModel> bookings;

    public void addBooking(BookingModel booking){
        if(bookings == null){
            bookings = new ArrayList<>();
        }

        bookings.add(booking);
    }
}
