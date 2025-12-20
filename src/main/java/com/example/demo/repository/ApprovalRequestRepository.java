package com.example.demo.repository;

import com.example.demo.model.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRequestRepository
        extends JpaRepository<ApprovalRequest, Long> {
}
