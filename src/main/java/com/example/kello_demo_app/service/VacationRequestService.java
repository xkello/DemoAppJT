package com.example.kello_demo_app.service;

import com.example.kello_demo_app.model.User;
import com.example.kello_demo_app.model.VacationRequest;
import com.example.kello_demo_app.model.VacationStatusUpdateRequest;
import com.example.kello_demo_app.repository.UserRepository;
import com.example.kello_demo_app.repository.VacationRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class VacationRequestService {

    private final VacationRequestRepository vacationRequestRepository;
    private final UserRepository userRepository;

    private BigDecimal calculateDays(VacationRequest request) {

        if (request.getStartDate() == null || request.getEndDate() == null) {
            return BigDecimal.ZERO;
        }

        long fullDaysBetween = ChronoUnit.DAYS.between(
                request.getStartDate(),
                request.getEndDate()
        ) - 1;
        // -1 because 1st and last day are calculated elsewhere

        if (fullDaysBetween < 0) fullDaysBetween = 0;

        BigDecimal total = BigDecimal.valueOf(fullDaysBetween);

        // Calculate first day
        total = total.add(dayPartValue(request.getStartPartOfDay()));

        // Calculate Last day
        total = total.add(dayPartValue(request.getEndPartOfDay()));

        return total;
    }

    private BigDecimal dayPartValue(String part) {
        if (part == null) return BigDecimal.ZERO;

        switch (part.toLowerCase()) {
            case "full day":
                return BigDecimal.valueOf(1.0);
            case "morning":
            case "afternoon":
            case "evening":
                return BigDecimal.valueOf(0.5);
            default:
                return BigDecimal.ZERO;
        }
    }



    public VacationRequestService(VacationRequestRepository vacationRequestRepository,
                                  UserRepository userRepository) {
        this.vacationRequestRepository = vacationRequestRepository;
        this.userRepository = userRepository;
    }

    public List<VacationRequest> getRequestsForUser(Long userId) {
        return vacationRequestRepository.findByCreatedById(userId);
    }

    // currentUserId - logged in user
    public VacationRequest createRequest(Long currentUserId, VacationRequest request) {
        User user = userRepository.findById(currentUserId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        request.setCreatedBy(user);

        if (request.getCreatedDate() == null) {
            request.setCreatedDate(LocalDate.now());
        }

        if (request.getStartDate() != null && request.getEndDate() != null) {
            request.setDays(calculateDays(request));
        }

        request.setStatus("NEW");

        if (request.getApprovedByManager() == null) {
            request.setApprovedByManager("-");
        }
        if (request.getApprovedByDirector() == null) {
            request.setApprovedByDirector("-");
        }

        return vacationRequestRepository.save(request);
    }

    // Cancel vacation can be hopefully done just by the logged in user
    public VacationRequest cancelRequest(Long requestId, Long currentUserId) {
        VacationRequest request = vacationRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found"));

        if (!request.getCreatedBy().getId().equals(currentUserId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You can cancel only your own request");
        }

        // Do nothing if already canceled - edge case but might happen
        // for duplicate server calls
        if ("CANCELLED_BY_USER".equals(request.getStatus())) {
            return request;
        }

        // Cancel request
        request.setStatus("CANCELLED_BY_USER");
        return vacationRequestRepository.save(request);
    }

    // VacationRequestService.java
    @Transactional
    public VacationRequest updateStatus(Long id, VacationStatusUpdateRequest dto) {
        VacationRequest request = vacationRequestRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found"));

        User current = userRepository.findById(dto.currentUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Simple auth
        if ("MANAGER".equalsIgnoreCase(current.getRole()) && "APPROVED_BY_MANAGER".equalsIgnoreCase(request.getStatus())) {
            request.setApprovedByManager(current.getFirstName());
        } else if ("DIRECTOR".equalsIgnoreCase(current.getRole()) && "APPROVED_BY_DIRECTOR".equalsIgnoreCase(request.getStatus())) {
            request.setApprovedByDirector(current.getFirstName());
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to approve this request");
        }

        request.setStatus(dto.status());
        return vacationRequestRepository.save(request);
    }
}
