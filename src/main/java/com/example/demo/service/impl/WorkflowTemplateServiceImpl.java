package com.example.demo.service.impl;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE (no duplicates)
    @Override
    public WorkflowTemplate create(WorkflowTemplate template) {

        if (repository.existsByTemplateName(template.getTemplateName())) {
            throw new DuplicateResourceException(
                    "Template with name '" + template.getTemplateName() + "' already exists");
        }

        return repository.save(template);
    }

    @Override
    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    @Override
    public WorkflowTemplate getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ UPDATE (prevent duplicate on update too)
    @Override
    public WorkflowTemplate update(Long id, WorkflowTemplate newData) {

        WorkflowTemplate old = repository.findById(id).orElse(null);

        if (old != null) {

            // check duplicate only if name is changed
            if (!old.getTemplateName().equals(newData.getTemplateName()) &&
                repository.existsByTemplateName(newData.getTemplateName())) {

                throw new DuplicateResourceException(
                        "Template with name '" + newData.getTemplateName() + "' already exists");
            }

            old.setTemplateName(newData.getTemplateName());
            old.setDescription(newData.getDescription());
            old.setTotalLevels(newData.getTotalLevels());
            old.setActive(newData.getActive());

            return repository.save(old);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
