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
@Table(name = "hall_tbl")
public class HallModel {
    @Id
    String hallID;
    String hallNo;
    String adminID;
    String status;
    String price;
    String type;
}
