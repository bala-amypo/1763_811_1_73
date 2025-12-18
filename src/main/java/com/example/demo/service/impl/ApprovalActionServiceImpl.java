package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.ApprovalAction;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    public ApprovalActionServiceImpl(
            ApprovalActionRepository actionRepo,
            ApprovalRequestRepository requestRepo) {
    }

    public ApprovalAction recordAction(ApprovalAction action) {
        return action;
    }
}
