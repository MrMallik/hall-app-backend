package com.hallapp.repository;

import com.hallapp.model.HallModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<HallModel, String> {
}
