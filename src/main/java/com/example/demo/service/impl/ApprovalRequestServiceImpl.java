package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    public ApprovalRequest createRequest(ApprovalRequest request) {
        return repository.save(request);
    }

    public ApprovalRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
    }

    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }

    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return repository.findByRequesterId(requesterId);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
