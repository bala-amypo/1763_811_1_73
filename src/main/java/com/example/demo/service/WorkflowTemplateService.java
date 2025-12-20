package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate save(WorkflowTemplate template);
    WorkflowTemplate getById(Long id);
    List<WorkflowTemplate> getAll();
    void delete(Long id);
}
