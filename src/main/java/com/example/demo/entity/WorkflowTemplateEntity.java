package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_templates", uniqueConstraints = {
        @UniqueConstraint(columnNames = "templateName")
})
public class WorkflowTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;
    private String description;
    private Integer totalLevels;
    private Boolean active;

    // getters & setters
}
