package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return repository.save(template);
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));

        existing.setTemplateName(template.getTemplateName());
        existing.setDescription(template.getDescription());
        existing.setTotalLevels(template.getTotalLevels());
        existing.setActive(template.getActive());

        return repository.save(existing);
    }

    public WorkflowTemplate getTemplateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    public void deleteTemplate(Long id) {
        repository.deleteById(id);
    }
}
