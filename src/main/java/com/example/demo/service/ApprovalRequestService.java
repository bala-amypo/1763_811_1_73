package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import java.util.List;

public interface ApprovalRequestService {
    ApprovalRequest createRequest(ApprovalRequest r);
    List<ApprovalRequest> getRequestsByRequester(Long id);
    List<ApprovalRequest> getAllRequests();
}
