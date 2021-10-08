package com.hallapp.service;

import com.hallapp.model.BookingModel;
import com.hallapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingModel> getBookingByUserID(String userID){
        return bookingRepository.findByUserID(userID);
    }
}
