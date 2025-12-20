package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate create(WorkflowTemplate template);

    WorkflowTemplate update(Long id, WorkflowTemplate template);

    WorkflowTemplate partialUpdate(Long id, WorkflowTemplate template);

    WorkflowTemplate getById(Long id);

    List<WorkflowTemplate> getAll();

    void delete(Long id);
}
