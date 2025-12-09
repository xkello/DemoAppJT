package com.example.kello_demo_app.model;

// Separate from VacationRequest to avoid DB complications
public record VacationStatusUpdateRequest(
        String status,
        Long currentUserId
) {}