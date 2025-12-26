package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository repo;
    private final ApprovalRequestRepository requestRepo;

    public ApprovalActionServiceImpl(ApprovalActionRepository repo,
                                     ApprovalRequestRepository requestRepo) {
        this.repo = repo;
        this.requestRepo = requestRepo;
    }

    public ApprovalAction recordAction(ApprovalAction action) {
        return repo.save(action);
    }
}
