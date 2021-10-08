package com.hallapp.repository;

import com.hallapp.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
    List<BookingModel> findByUserID(String userID);
}
