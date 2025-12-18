package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_step_configs")
public class WorkflowStepConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CRITICAL: store ID only
    private Long templateId;

    private Integer levelNumber;
    private String approverRole;
    private Boolean isFinalStep;
    private String instructions;

    // getters & setters
}
