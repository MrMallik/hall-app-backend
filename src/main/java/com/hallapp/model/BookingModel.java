package com.hallapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_tbl")
public class BookingModel {
    @Id
    @GeneratedValue
    Long bookingID;
    String hallID;
    String userID;

    public BookingModel(String hallID, String userID){
        this.hallID = hallID;
        this.userID = userID;
    }
}
