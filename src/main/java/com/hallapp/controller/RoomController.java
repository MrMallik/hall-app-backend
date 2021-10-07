package com.hallapp.controller;

import com.hallapp.model.HallModel;
import com.hallapp.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    private HallService hallService;


    @GetMapping("/getHall/{id}")
    public Optional<HallModel> getHall(@PathVariable String id){
        Optional<HallModel> hall = hallService.getHall(id);

        return hall;
    }

    @PostMapping("/addHall")
    public HallModel saveHall(@RequestBody HallModel hall){
        return hallService.saveHall(hall);
    }

    @PostMapping("/editHall")
    public HallModel editHall(@RequestBody HallModel hall){
        return hallService.editHall(hall);
    }

    @DeleteMapping("/deleteHall/{hallID}")
    public void deleteHall(@PathVariable String hallID){
        hallService.deleteHall(hallID);
    }

    @GetMapping("/getHalls")
    public List<HallModel> getHalls(@RequestBody String adminEmail){
        return hallService.getHalls(adminEmail);
    }

    @PostMapping("/bookHall/{id}")
    public void bookHall(@PathVariable String id){
        if(hallService.bookHall(id)){
            System.out.println("Booking Complete!");
        } else{
            System.out.println("Booking couldn't be confirmed!");
        }
    }
}
