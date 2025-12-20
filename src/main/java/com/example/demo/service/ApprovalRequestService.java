package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import java.util.List;

public interface ApprovalRequestService {

    ApprovalRequest save(ApprovalRequest request);
    ApprovalRequest getById(Long id);
    List<ApprovalRequest> getAll();
    void delete(Long id);
}
