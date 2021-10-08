package com.hallapp.service;

import com.hallapp.model.AdminModel;
import com.hallapp.model.BookingModel;
import com.hallapp.model.HallModel;
import com.hallapp.repository.AdminRepository;
import com.hallapp.repository.BookingRepository;
import com.hallapp.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public HallModel saveHall(HallModel hall){
        return hallRepository.save(hall);
    }

    public HallModel editHall(HallModel editedHall){
        HallModel currHall = hallRepository.getById(editedHall.getHallID());
        currHall.setPrice(editedHall.getPrice());
        currHall.setStatus(editedHall.getStatus());
        currHall.setType(editedHall.getType());
        currHall.setAdminID(editedHall.getAdminID());
        currHall.setHallID(editedHall.getHallID());
        currHall.setHallNo(editedHall.getHallNo());
        //TODO : Fill the other setters
        return hallRepository.save(currHall);
    }

    public void deleteHall(String hallID){
        hallRepository.deleteById(hallID);
    }

    public Optional<HallModel> getHall(String hallID){
        return hallRepository.findById(hallID);
    }

    public List<HallModel> getHalls(String adminEmail){
        AdminModel currAdmin = adminRepository.getById(adminEmail);
        if(currAdmin != null)
            return hallRepository.findAll();

        return new ArrayList<>();
    }

    public void changeStatusToBooking(String hallID){
        Optional<HallModel> curr = getHall(hallID);
        if(curr.isPresent()){
            curr.get().setStatus("booked");
            hallRepository.save(curr.get());
        } else{
            System.out.println("Couldn't change status to booking. Error Occured!");
        }
    }

    public boolean bookHall(String hallID, String userID){
        Optional<HallModel> currHall = getHall(hallID);
        if(currHall.isPresent() &&
                !currHall.get().getStatus().equalsIgnoreCase("booked")){
            changeStatusToBooking(hallID);
            bookingRepository.save(new BookingModel(hallID, userID));
            return true;
        }

        return false;
    }
}
