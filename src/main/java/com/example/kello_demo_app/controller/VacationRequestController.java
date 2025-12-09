package com.example.kello_demo_app.controller;

import com.example.kello_demo_app.model.VacationRequest;
import com.example.kello_demo_app.model.VacationStatusUpdateRequest;
import com.example.kello_demo_app.service.VacationRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacations")
public class VacationRequestController {

    private final VacationRequestService vacationRequestService;

    public VacationRequestController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }

    // List of requests for selected user in dropdown menu
    @GetMapping
    public List<VacationRequest> getRequestsForUser(@RequestParam Long userId) {
        return vacationRequestService.getRequestsForUser(userId);
    }

    // Create new request (logged in user = currentUserId)
    @PostMapping
    public ResponseEntity<VacationRequest> createRequest(
            @RequestParam Long currentUserId,
            @RequestBody VacationRequest request) {

        VacationRequest saved = vacationRequestService.createRequest(currentUserId, request);
        return ResponseEntity.ok(saved);
    }

    // Cancel request, only logged in user for his own requests if all stars aligned
    @DeleteMapping("/{id}")
    public ResponseEntity<VacationRequest> cancelRequest(
            @PathVariable Long id,
            @RequestParam Long currentUserId) {

        VacationRequest cancelled = vacationRequestService.cancelRequest(id, currentUserId);
        return ResponseEntity.ok(cancelled);
    }

    // VacationRequestController.java
    @PutMapping("/{id}/status")
    public ResponseEntity<VacationRequest> updateStatus(
            @PathVariable Long id,
            @RequestBody VacationStatusUpdateRequest body
    ) {
        VacationRequest updated = vacationRequestService.updateStatus(id, body);
        return ResponseEntity.ok(updated);
    }
}
