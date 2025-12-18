package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval_requests")
public class ApprovalRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Long requesterId;
    private String requestTitle;

    @Column(columnDefinition = "LONGTEXT")
    private String requestPayloadJson;

    private String status = "PENDING";
    private Integer currentLevel;
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
