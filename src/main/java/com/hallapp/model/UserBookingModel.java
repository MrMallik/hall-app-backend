package com.hallapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserBookingModel {
    String hallID;
    String userID;

    public String getHallID() {
        return hallID;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
