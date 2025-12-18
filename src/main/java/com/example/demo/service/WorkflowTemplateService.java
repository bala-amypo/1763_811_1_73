package com.example.demo.service;


import com.example.demo.entity.WorkflowTemplate;
import java.util.List;

public interface WorkflowTemplateService {
    WorkflowTemplate createTemplate(WorkflowTemplate t);
    WorkflowTemplate getTemplateById(Long id);
    List<WorkflowTemplate> getAllTemplates();
    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t);
    void activateTemplate(Long id, boolean active);
}
