package com.example.demo.serviceimpl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl
        implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(
            WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowTemplate createTemplate(
            WorkflowTemplate template) {
        return repository.save(template);
    }

    @Override
    public Optional<WorkflowTemplate>
    getTemplateById(Long id) {
        return repository.findById(id);
    }

    @Override
    public WorkflowTemplate updateTemplate(
            Long id,
            WorkflowTemplate template) {

        WorkflowTemplate existing =
                repository.findById(id).orElseThrow();

        existing.setDescription(
                template.getDescription());

        return repository.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(
            Long id,
            boolean active) {

        WorkflowTemplate template =
                repository.findById(id).orElseThrow();

        template.setActive(active);
        return repository.save(template);
    }

    @Override
    public List<WorkflowTemplate>
    getAllTemplates() {
        return repository.findAll();
    }
}
