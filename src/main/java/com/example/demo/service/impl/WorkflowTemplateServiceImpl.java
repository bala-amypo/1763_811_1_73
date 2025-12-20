package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    // POST
    public WorkflowTemplate create(WorkflowTemplate template) {
        return repository.save(template);
    }

    // PUT (full update)
    public WorkflowTemplate update(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTemplateName(template.getTemplateName());
        existing.setDescription(template.getDescription());
        existing.setTotalLevels(template.getTotalLevels());
        existing.setActive(template.getActive());

        return repository.save(existing);
    }

    // PATCH (partial update)
    public WorkflowTemplate partialUpdate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        if (template.getTemplateName() != null)
            existing.setTemplateName(template.getTemplateName());

        if (template.getDescription() != null)
            existing.setDescription(template.getDescription());

        if (template.getTotalLevels() != null)
            existing.setTotalLevels(template.getTotalLevels());

        if (template.getActive() != null)
            existing.setActive(template.getActive());

        return repository.save(existing);
    }

    // GET by id
    public WorkflowTemplate getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // GET all
    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
