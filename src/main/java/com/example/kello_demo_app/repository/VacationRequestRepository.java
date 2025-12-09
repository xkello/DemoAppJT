package com.example.kello_demo_app.repository;

import com.example.kello_demo_app.model.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {

    // List of vacation requests maybe by certain user (can be fetched from dropdown for example)
    List<VacationRequest> findByCreatedById(Long userId);
}
