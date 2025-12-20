package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private WorkflowTemplateRepository repository;

    // Constructor Injection
    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public WorkflowTemplate saveTemplate(WorkflowTemplate template) {
        return repository.save(template);
    }

    // UPDATE
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {

        WorkflowTemplate existingTemplate = repository.findById(id).orElse(null);

        if (existingTemplate != null) {
            existingTemplate.setTemplateName(template.getTemplateName());
            existingTemplate.setDescription(template.getDescription());
            existingTemplate.setTotalLevels(template.getTotalLevels());
            existingTemplate.setActive(template.getActive());

            return repository.save(existingTemplate);
        }

        return null;
    }

    // READ by ID
    public WorkflowTemplate getTemplateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // READ all
    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    // DELETE
    public void deleteTemplate(Long id) {
        repository.deleteById(id);
    }
}
